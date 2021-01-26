package pl.book.controllers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pl.book.entities.Book;
import pl.book.manager.BookManager;

@Controller
public class BookController {
	@Autowired
	private BookManager bookManager;
	
	@Autowired
	public BookController(BookManager bookManager) {
		super();
		this.bookManager = bookManager;
	}
	
	@GetMapping("/all")
	public Iterable<Book> getAll(){
		return bookManager.findAll();
	}

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public ModelAndView subjects(HttpServletRequest request){
      Iterable<Book> books = bookManager.findAll();
      ModelAndView model = new ModelAndView("/index.html");
      model.addObject("books", books);
      return model;
  }


}
