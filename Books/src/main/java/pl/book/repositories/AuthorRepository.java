package pl.book.repositories;

import org.springframework.data.repository.CrudRepository;

import pl.book.entities.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
