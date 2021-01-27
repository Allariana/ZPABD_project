package pl.book.controllers;

import java.util.Calendar;

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
import pl.book.manager.BookManager;
import pl.book.manager.MarkManager;
import pl.book.repositories.MarkRepository;

@Controller
public class MarkController {

	@Autowired
	private MarkManager markManager;
	@Autowired
	private MarkRepository markRepository;

	@Autowired
	public MarkController(MarkManager markManager, MarkRepository markRepository) {
		super();
		this.markManager = markManager;
		this.markRepository = markRepository;
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
	public ModelAndView addMarkConfirm(HttpServletRequest request) {
		String bookid = request.getParameter("bookId");
		String value = request.getParameter("value");

		// pobrac z manager

		Mark mark = new Mark();
		mark.setValue(4.5);
		mark.setDate(new java.sql.Date(Calendar.getInstance().getTime().getTime()));
//		mark.setReviewer();
//		mark.setBook();

		markRepository.save(mark);

		return this.marks(request);
	}
}
