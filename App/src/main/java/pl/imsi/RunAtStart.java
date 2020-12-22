package pl.imsi;


import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class RunAtStart {

	private final BookRepository bookRepository;
	private final AuthorRepository authorRepository;
	private final TypeRepository typeRepository;

	@Autowired
	public RunAtStart(BookRepository bookRepository, AuthorRepository authorRepository, TypeRepository typeRepository) {
		super();
		this.bookRepository = bookRepository;
		this.authorRepository = authorRepository;
		this.typeRepository = typeRepository;

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
	}
	
	
}
