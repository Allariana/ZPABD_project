package pl.book.manager;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.book.entities.Mark;
import pl.book.entities.Reviewer;
import pl.book.repositories.ReviewerRepository;

@Service
public class ReviewerManager {
	private final ReviewerRepository reviewerRepository;
	
    @Autowired
    public ReviewerManager(ReviewerRepository reviewerRepository) {
        super();
        this.reviewerRepository = reviewerRepository;
    }
    
    public Iterable<Reviewer> findAll() {
        return reviewerRepository.findAll();
    }
    
	public Optional<Reviewer> findById(Long id) {
		return reviewerRepository.findById(id);
	}
	public Reviewer findByUsername(String username) {
		return reviewerRepository.findByUsername(username);
	}
	
    public Iterable<Reviewer> findAllWhereId(Long bookId) {
        return reviewerRepository.findAllWhereId(bookId);
    }
}