package pl.book.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import pl.book.entities.Mark;

public interface MarkRepository extends CrudRepository<Mark, Long> {
	
	@Query("SELECT m FROM Mark m WHERE m.book.book_id = ?1")
	Iterable<Mark> findAllWhereBookId(Long book_id);
}
