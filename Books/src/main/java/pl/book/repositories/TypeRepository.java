package pl.book.repositories;

import org.springframework.data.repository.CrudRepository;

import pl.book.entities.Type;

public interface TypeRepository extends CrudRepository<Type, Long> {

}
