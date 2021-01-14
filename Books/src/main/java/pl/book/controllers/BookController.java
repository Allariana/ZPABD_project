package pl.book.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import pl.book.entities.Book;
import pl.book.manager.BookManager;

//@RestController
@Controller
@RequestMapping("/book")
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
    @RequestMapping(value = "/b", method = RequestMethod.GET)
    public ModelAndView subjects(HttpServletRequest request){
        ModelAndView model = new ModelAndView("/book.html");
        ArrayList<Book> books = new ArrayList<>();
        for(Book book : books){
            books.add(book);
        }
        model.addObject("books", books);
        return model;
    }
}
