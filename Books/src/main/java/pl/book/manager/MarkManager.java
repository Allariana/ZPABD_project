package pl.book.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.book.entities.Mark;
import pl.book.repositories.MarkRepository;

@Service
public class MarkManager {
	private final MarkRepository markRepository;
	
    @Autowired
    public MarkManager(MarkRepository markRepository) {
        super();
        this.markRepository = markRepository;
    }
    
    public Iterable<Mark> findAll() {
        return markRepository.findAll();
    }
    
    public Iterable<Mark> findAllWhereBookId(Long bookId) {
        return markRepository.findAllWhereBookId(bookId);
    }
}
