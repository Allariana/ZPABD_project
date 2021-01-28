package pl.book.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import pl.book.entities.Mark;
import pl.book.entities.Reviewer;

public interface ReviewerRepository extends CrudRepository<Reviewer, Long> {
	@Query("SELECT r FROM Reviewer r WHERE r.reviewer_id = ?1")
	Iterable<Reviewer> findAllWhereId(Long reviewer_id);
	
	@Query("SELECT r FROM Reviewer r WHERE r.username = ?1")
	Reviewer findByUsername(String username);
}