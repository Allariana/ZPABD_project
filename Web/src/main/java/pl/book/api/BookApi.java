package pl.book.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.book.entities.Book;
import pl.book.manager.BookManager;

@RestController
@RequestMapping("/api/book")
public class BookApi {
	
	private BookManager bookManager;
	
	@Autowired
	public BookApi(BookManager bookManager) {
		super();
		this.bookManager = bookManager;
	}
	
	@GetMapping("/all")
	public Iterable<Book> getAll(){
		return bookManager.findAll();
	}

}
