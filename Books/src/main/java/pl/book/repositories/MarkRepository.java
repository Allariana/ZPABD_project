package pl.book.repositories;

import org.springframework.data.repository.CrudRepository;

import pl.book.entities.Mark;

public interface MarkRepository extends CrudRepository<Mark, Long> {

}
