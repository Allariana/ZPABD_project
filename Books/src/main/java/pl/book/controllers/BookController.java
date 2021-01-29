package pl.book.controllers;

import javax.servlet.http.HttpServletRequest;

import com.fasterxml.jackson.databind.ser.Serializers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pl.book.base.BaseController;
import pl.book.entities.*;
import pl.book.manager.*;
import pl.book.repositories.BookRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BookController extends BaseController {
    @Autowired
    private BookManager bookManager;
    @Autowired
    private TypeManager typeManager;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private MarkManager markManager;
    @Autowired
    private ReviewerManager reviewerManager;
    @Autowired
    private AuthorManager authorManager;

    Logger logger = LoggerFactory.getLogger(SpringBootApplication.class);

    @Autowired
    public BookController(BookManager bookManager,TypeManager typeManager, BookRepository bookRepository, AuthorManager authorManager) {
        super();
        this.bookManager = bookManager;
        this.bookRepository = bookRepository;
        this.typeManager = typeManager;
        this.authorManager = authorManager;
    }

    @GetMapping("/all")
    public Iterable<Book> getAll() {
        return bookManager.findAll();
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView books(HttpServletRequest request) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		authentication.getAuthorities();
        logger.info("Authenticated user has authorities: " + authentication.getAuthorities());
        Reviewer currentUserReviewer = null;
        Iterable<Book> books = bookManager.findAll();
        Iterable<Mark> marks = null;
        List<Long> markedBooksIdsList = new ArrayList<>();
        boolean isUserAuthenticated = checkIfUserIsAuthenticated();
        boolean isAdminAuthenticated = checkIfUserIsAuthenticated();
        if (isUserAuthenticated) {
            String username = SecurityContextHolder.getContext().getAuthentication().getName();
            logger.info("Authenticated username = " + username);
            if (username != null && !username.isEmpty()) {
                currentUserReviewer = reviewerManager.findByUsername(username);
                if (currentUserReviewer != null) {
                    isAdminAuthenticated = false;
                    logger.info("Authenticated reviewer id = " + currentUserReviewer.getReviewer_id());
                    marks = markManager.findAllWhereReviewerId(currentUserReviewer.getReviewer_id());
                    logger.info("Authenticated reviewers marks: " + marks);
                    for (Mark mark : marks) {
                        markedBooksIdsList.add(mark.getBook().getBook_id());
                    }
                } else
                    isUserAuthenticated = false;
            }
        } else {
            logger.info("User is not authenticated");
        }
        ModelAndView model = new ModelAndView("index.html");
        model.addObject("books", books);
        model.addObject("committedMarksIds", markedBooksIdsList);
        model.addObject("committedMarks", marks);
        model.addObject("isUserAuthenticated", isUserAuthenticated);
        model.addObject("isAdminAuthenticated", isAdminAuthenticated);

        return model;
    }
    @RequestMapping(value = "/admin/addBook", method = RequestMethod.GET)
    public ModelAndView addMarks(HttpServletRequest request) {
        Iterable<Type> types = typeManager.findAll();
        Iterable<Author> authors = authorManager.findAll();
        ModelAndView model = new ModelAndView("/admin/addBook.html");
        model.addObject("types", types);
        model.addObject("authors", authors);
        return model;
    }

    @RequestMapping(value = "/admin/addBook", method = RequestMethod.POST)
    public void addBook(HttpServletRequest request) {
        String authorName = request.getParameter("author");
        String typeName = request.getParameter("type");
        String title = request.getParameter("title");

        //Author author = authorManager.findbyLastname(authorName);
//        Type type = typeManager.findByName(typeName);
//        Book book = new Book();
//        book.setTitle(title);
//        //book.setAuthor(author);
//        book.setType(type);
//        bookRepository.save(book);
    }

}