package pl.book;


import java.util.Calendar;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.book.entities.Author;
import pl.book.entities.Book;
import pl.book.entities.Mark;
import pl.book.entities.Type;
import pl.book.entities.Reviewer;
import pl.book.repositories.AuthorRepository;
import pl.book.repositories.BookRepository;
import pl.book.repositories.MarkRepository;
import pl.book.repositories.ReviewerRepository;
import pl.book.repositories.TypeRepository;


@Component
public class RunAtStart {

	private final BookRepository bookRepository;
	private final AuthorRepository authorRepository;
	private final TypeRepository typeRepository;
	private final MarkRepository markRepository;
	private final ReviewerRepository reviewerRepository;

	@Autowired
	public RunAtStart(BookRepository bookRepository, AuthorRepository authorRepository, TypeRepository typeRepository
			,MarkRepository markRepository,ReviewerRepository reviewerRepository) {
		super();
		this.bookRepository = bookRepository;
		this.authorRepository = authorRepository;
		this.typeRepository = typeRepository;
		this.markRepository	= markRepository;
		this.reviewerRepository = reviewerRepository;

	}

	@PostConstruct
	public void runAtStart() {
		Author author = new Author();
		author.setLastName("Rowling");
		author.setFirstName("J.K.");
		authorRepository.save(author);
		Author author2 = new Author();
		author2.setLastName("Hawkins");
		author2.setFirstName("Paula");
		authorRepository.save(author2);
		Author author3 = new Author();
		author3.setLastName("Michaelides");
		author3.setFirstName("Alex");
		authorRepository.save(author3);
		
		Type type = new Type();
		type.setName("Fantasy");
		typeRepository.save(type);
		Type type2 = new Type();
		type2.setName("Thriller");
		typeRepository.save(type2);
		
		Book book = new Book();
		book.setTitle("Harry Potter i Kamień Filozoficzny");
		book.setAuthor(author);
		book.setType(type);
		bookRepository.save(book);
		Book book2 = new Book();
		book2.setTitle("Harry Potter i Komnata Tajemnic");
		book2.setAuthor(author);
		book2.setType(type);
		bookRepository.save(book2);
		Book book3 = new Book();
		book3.setTitle("Dziewczyna z pociagu");
		book3.setAuthor(author2);
		book3.setType(type2);
		bookRepository.save(book3);
		Book book4 = new Book();
		book4.setTitle("Pacjentka");
		book4.setAuthor(author3);
		book4.setType(type2);
		bookRepository.save(book4);
		
		Reviewer reviewer = new Reviewer();
		reviewer.setFirstName("Kinga");
		reviewer.setLastName("Sochacka");
		reviewer.setEmail("234005@edu.p.lodz.pl");
		reviewer.setUsername("Allariana");
		reviewerRepository.save(reviewer);
		Reviewer reviewer2 = new Reviewer();
		reviewer2.setFirstName("Wojciech");
		reviewer2.setLastName("Jurek");
		reviewer2.setEmail("208911@edu.p.lodz.pl");
		reviewer2.setUsername("wjurek");
		reviewerRepository.save(reviewer2);
		Reviewer reviewer3 = new Reviewer();
		reviewer3.setFirstName("Izabela");
		reviewer3.setLastName("Pieczek");
		reviewer3.setEmail("233994@edu.p.lodz.pl");
		reviewer3.setUsername("IzabelaPieczek");
		reviewerRepository.save(reviewer3);
		
		Mark mark = new Mark();
		mark.setValue(4.5);
		mark.setDate(new java.sql.Date(Calendar.getInstance().getTime().getTime()));
		mark.setReviewer(reviewer);
		mark.setBook(book);
		markRepository.save(mark);
		Mark mark2 = new Mark();
		mark2.setValue(4.0);
		mark2.setDate(new java.sql.Date(Calendar.getInstance().getTime().getTime()));
		mark2.setReviewer(reviewer2);
		mark2.setBook(book);
		markRepository.save(mark2);
		Mark mark3 = new Mark();
		mark3.setValue(5.0);
		mark3.setDate(new java.sql.Date(Calendar.getInstance().getTime().getTime()));
		mark3.setReviewer(reviewer);
		mark3.setBook(book2);
		markRepository.save(mark3);
		Mark mark4 = new Mark();
		mark4.setValue(4.5);
		mark4.setDate(new java.sql.Date(Calendar.getInstance().getTime().getTime()));
		mark4.setReviewer(reviewer2);
		mark4.setBook(book2);
		markRepository.save(mark4);
		Mark mark5 = new Mark();
		mark5.setValue(4.0);
		mark5.setDate(new java.sql.Date(Calendar.getInstance().getTime().getTime()));
		mark5.setReviewer(reviewer3);
		mark5.setBook(book3);
		markRepository.save(mark5);
		Mark mark6 = new Mark();
		mark6.setValue(5.0);
		mark6.setDate(new java.sql.Date(Calendar.getInstance().getTime().getTime()));
		mark6.setReviewer(reviewer3);
		mark6.setBook(book4);
		markRepository.save(mark6);
	}
	
	
}
