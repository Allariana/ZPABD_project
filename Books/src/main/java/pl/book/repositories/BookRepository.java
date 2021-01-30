package pl.book.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import pl.book.entities.Book;

public interface BookRepository extends CrudRepository<Book, Long>{

	@Query("select AVG(m.value) as srednia from Book b join Mark m on b=m.book where b.book_id= ?1 group by b.book_id")
	Double findAverageMark(Long book_id);
	
	@Query("SELECT b FROM Book b WHERE b.book_id = ?1")
	Book findBookById(Long bookId);

	@Query("SELECT b FROM Book b order by b.averageMark DESC")
	Iterable<Book> findBooksOrder();
}
