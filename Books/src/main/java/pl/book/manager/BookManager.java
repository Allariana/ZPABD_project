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
    
    public Double findAverageMark(Long book_id) {
        return bookRepository.findAverageMark(book_id);
    }
    
    public Book findBookById(Long bookId) {

        return bookRepository.findBookById(bookId);
    }

    public Iterable<Book> findBooksOrder(){
        return bookRepository.findBooksOrder();
    }

}
