package pl.book.controllers;

import java.util.Calendar;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pl.book.entities.Book;
import pl.book.entities.Mark;
import pl.book.entities.Reviewer;
import pl.book.manager.BookManager;
import pl.book.manager.MarkManager;
import pl.book.manager.ReviewerManager;
import pl.book.repositories.BookRepository;
import pl.book.repositories.MarkRepository;

@Controller
public class MarkController {

	@Autowired
	private MarkManager markManager;
	@Autowired
	private MarkRepository markRepository;
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private BookManager bookManager;
	@Autowired
	private ReviewerManager reviewerManager;

	@Autowired
	public MarkController(MarkManager markManager, MarkRepository markRepository, ReviewerManager reviewerManager,
			BookRepository bookRepository) {
		super();
		this.markManager = markManager;
		this.markRepository = markRepository;
		this.bookManager = bookManager;
		this.reviewerManager = reviewerManager;
		this.bookRepository = bookRepository;
	}

	@GetMapping("/allmarks")
	public Iterable<Mark> getAll() {
		return markManager.findAll();
	}

	@RequestMapping(value = "/marks", method = RequestMethod.GET)
	public ModelAndView marks(HttpServletRequest request) {
		Iterable<Mark> marks = markManager.findAllWhereBookId(Long.valueOf(request.getParameter("bookId")));
		ModelAndView model = new ModelAndView("/marks.html");
		model.addObject("marks", marks);
		return model;
	}

	@RequestMapping(value = "/reviewer/addmark", method = RequestMethod.GET)
	public ModelAndView addMarks(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("/reviewer/addmark.html");
		return model;
	}

	@RequestMapping(value = "/reviewer/addmark", method = RequestMethod.POST)
	public void addMarkConfirm(HttpServletRequest request) {
		String bookid = request.getParameter("bookId");
		Double value = Double.parseDouble(request.getParameter("value"));
		String username = request.getRemoteUser();

		Mark mark = new Mark();
		mark.setValue(value);
		mark.setDate(new java.sql.Date(Calendar.getInstance().getTime().getTime()));

		Reviewer reviewer = reviewerManager.findByUsername(username);
		mark.setReviewer(reviewer);
		Book book = bookManager.findBookById(Long.valueOf(bookid));
		mark.setBook(book);

		markRepository.save(mark);
		Double averageMark = bookManager.findAverageMark(Long.valueOf(bookid));
		book.setAverageMark(averageMark);
		bookRepository.save(book);

	}
}
