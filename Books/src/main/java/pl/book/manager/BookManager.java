package pl.book.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.book.entities.Book;
import pl.book.repositories.BookRepository;

@Service
public class BookManager {
	private final BookRepository bookRepository;
	
    @Autowired
    public BookManager(BookRepository bookRepository) {
        super();
        this.bookRepository = bookRepository;
    }
    
    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }

}