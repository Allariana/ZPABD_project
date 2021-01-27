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
	private BookManager bookManager;
	@Autowired
	private ReviewerManager reviewerManager;

	@Autowired
	public MarkController(MarkManager markManager, MarkRepository markRepository, ReviewerManager reviewerManager) {
		super();
		this.markManager = markManager;
		this.markRepository = markRepository;
		this.bookManager = bookManager;
		this.reviewerManager = reviewerManager;
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
		// Iterable<Mark> marks =
		// markManager.findAllWhereBookId(Long.valueOf(request.getParameter("bookId")));
		ModelAndView model = new ModelAndView("/reviewer/addmark.html");
		// model.addObject("marks", marks);
		return model;
	}

	@RequestMapping(value = "/reviewer/addmark", method = RequestMethod.POST)
	public void addMarkConfirm(HttpServletRequest request) {
		String bookid = request.getParameter("bookId");
		Double value = Double.parseDouble(request.getParameter("value"));
		String username = request.getRemoteUser();
		
		System.out.println("Username " + username);
		System.out.println("Debugowanie_Id_ksiazki " + bookid);
		System.out.println("Debugowanie_value_ksiazki " + value);

		// pobrac z manager

		Mark mark = new Mark();
		mark.setValue(value);
		mark.setDate(new java.sql.Date(Calendar.getInstance().getTime().getTime()));
		
		System.out.println("Debugowanie_oceny_xd " + mark);
		for(Mark markbefore : markManager.findAll()) {
			System.out.println("DEBUG_PRZED " + markbefore.getValue());
			System.out.println("DEBUG_PRZED " + markbefore.getBook());
		}
		Reviewer reviewer = reviewerManager.findByUsername(username);
		mark.setReviewer(reviewer);
		Iterable<Book> books = bookManager.findAllWhereId(Long.valueOf(bookid));
		while(books.iterator().hasNext()) {
			mark.setBook(books.iterator().next());
			break;
		}

		

		markRepository.save(mark);
		
		for(Mark markafter : markManager.findAll()) {
			System.out.println("DEBUG_PO " + markafter.getValue());
			System.out.println("DEBUG_PO " + markafter.getBook());
		}
		
		
//		mark.setReviewer();


		//return this.marks(request);
	}
}
