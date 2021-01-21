package pl.book.controllers;

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

@Controller
public class MarkController {

	@Autowired
	private MarkManager markManager;
	
	@Autowired
	public MarkController(MarkManager markManager) {
		super();
		this.markManager = markManager;
	}
	
	@GetMapping("/allmarks")
	public Iterable<Mark> getAll(){
		return markManager.findAll();
	}

  @RequestMapping(value = "/marks", method = RequestMethod.GET)
  public ModelAndView subjects(HttpServletRequest request){
      Iterable<Mark> marks = markManager.findAllWhereBookId(Long.valueOf(request.getParameter("bookId")));
      ModelAndView model = new ModelAndView("/marks.html");
      model.addObject("marks", marks);
      return model;
  }
  
}
