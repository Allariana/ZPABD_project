package pl.imsi;


import java.util.Calendar;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


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
		
		Type type = new Type();
		type.setName("Fantasy");
		typeRepository.save(type);
		
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
		
		Reviewer reviewer = new Reviewer();
		reviewer.setFirstName("Kinga");
		reviewer.setLastName("Sochacka");
		reviewer.setEmail("234005@edu.p.lodz.pl");
		reviewer.setUsername("Allariana");
		reviewerRepository.save(reviewer);
		Reviewer reviewer2 = new Reviewer();
		reviewer2.setFirstName("Wiktor");
		reviewer2.setLastName("Olszewski");
		reviewer2.setEmail("olszewki@gmail.com");
		reviewer2.setUsername("wolszewski");
		reviewerRepository.save(reviewer2);
		
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
	}
	
	
}
