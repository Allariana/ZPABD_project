package pl.book.repositories;

import org.springframework.data.repository.CrudRepository;

import pl.book.entities.Book;

public interface BookRepository extends CrudRepository<Book, Long>{

}
