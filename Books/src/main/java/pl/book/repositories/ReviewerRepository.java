package pl.book.repositories;

import org.springframework.data.repository.CrudRepository;

import pl.book.entities.Reviewer;

public interface ReviewerRepository extends CrudRepository<Reviewer, Long> {

}
