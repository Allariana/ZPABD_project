package pl.book.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import pl.book.entities.Mark;

public interface MarkRepository extends CrudRepository<Mark, Long> {
	
	@Query("SELECT m FROM Mark m WHERE m.book.book_id = ?1")
	Iterable<Mark> findAllWhereBookId(Long book_id);

	@Query("SELECT m FROM Mark m WHERE m.reviewer.reviewer_id = ?1")
    Iterable<Mark> findAllWhereReviewerId(Long userId);

	@Query("SELECT m FROM Mark m WHERE m.book.book_id = ?1 AND m.reviewer.reviewer_id = ?2")
	Iterable<Mark> findAllByBookIdAndReviewerId(Long bookId, Long reviewerId);

}