package pl.book.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.book.entities.Author;
import pl.book.repositories.AuthorRepository;

@Service
public class AuthorManager {
	private final AuthorRepository authorRepository;
	
    @Autowired
    public AuthorManager(AuthorRepository authorRepository) {
        super();
        this.authorRepository = authorRepository;
    }
    
    public Iterable<Author> findAll() {
        return authorRepository.findAll();
    }
}
