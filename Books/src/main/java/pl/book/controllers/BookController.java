package pl.book.controllers;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pl.book.entities.Book;
import pl.book.entities.Mark;
import pl.book.entities.Reviewer;
import pl.book.manager.BookManager;
import pl.book.manager.MarkManager;
import pl.book.manager.ReviewerManager;
import pl.book.repositories.BookRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookManager bookManager;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private MarkManager markManager;
    @Autowired
    private ReviewerManager reviewerManager;

    Logger logger = LoggerFactory.getLogger(SpringBootApplication.class);

    @Autowired
    public BookController(BookManager bookManager, BookRepository bookRepository) {
        super();
        this.bookManager = bookManager;
        this.bookRepository = bookRepository;
    }

    @GetMapping("/all")
    public Iterable<Book> getAll() {
        return bookManager.findAll();
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView subjects(HttpServletRequest request) {
        Iterable<Book> books = bookManager.findAll();
        Iterable<Mark> marks = null;
        List<Long> markedBooksIdsList = new ArrayList<>();
        boolean isUserAuthenticated = checkIfUserIsAuthenticated();
        if (isUserAuthenticated) {
            String username = SecurityContextHolder.getContext().getAuthentication().getName();
            logger.info("Authenticated username = " + username);
            if (username != null && !username.isEmpty()) {
                Reviewer currentUserReviewer = reviewerManager.findByUsername(username);
                logger.info("Authenticated reviewer id = " + currentUserReviewer.getReviewer_id());
                marks = markManager.findAllWhereReviewerId(currentUserReviewer.getReviewer_id());
                logger.info("Authenticated reviewers marks: " + marks);
                for(Mark mark : marks) {
                    markedBooksIdsList.add(mark.getBook().getBook_id());
                }
            }
        } else {
            logger.info("User is not authenticated");
        }

        ModelAndView model = new ModelAndView("index.html");
        model.addObject("books", books);
        model.addObject("committedMarksIds", markedBooksIdsList);
        model.addObject("committedMarks", marks);
        model.addObject("isUserAuthenticated", isUserAuthenticated);
        return model;
    }

    boolean checkIfUserIsAuthenticated() {
        return SecurityContextHolder.getContext().getAuthentication() != null &&
                SecurityContextHolder.getContext().getAuthentication().isAuthenticated() &&
                //when Anonymous Authentication is enabled
                !(SecurityContextHolder.getContext().getAuthentication()
                        instanceof AnonymousAuthenticationToken);
    }
}