package pl.book.repositories;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import pl.book.entities.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {
	@Query("SELECT a FROM Author a WHERE a.id = ?1")
	Iterable<Author> findAllWhereAuthorId(Long id);
	@Query("SELECT a FROM Author a WHERE a.LastName = ?1")
	Author findbyLastname(String lastname);

}
