package pl.book.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import pl.book.entities.Type;

public interface TypeRepository extends CrudRepository<Type, Long> {

	@Query("SELECT t FROM Type t WHERE t.id = ?1")
	Iterable<Type> findAllWhereTypeId(Long id);
	
	@Query("SELECT t FROM Type t WHERE t.name = ?1")
	Type findByName(String name);
}
