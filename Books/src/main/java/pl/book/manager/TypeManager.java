package pl.book.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.book.entities.Type;
import pl.book.repositories.TypeRepository;

@Service
public class TypeManager {
	private final TypeRepository typeRepository;
	
    @Autowired
    public TypeManager(TypeRepository typeRepository) {
        super();
        this.typeRepository = typeRepository;
    }
    
    public Iterable<Type> findAll() {
        return typeRepository.findAll();
    }
    
    public Iterable<Type> findAllWhereTypeId(Long id) {
        return typeRepository.findAllWhereTypeId(id);
    }
    
	public Type findByName(String name) {
		return typeRepository.findByName(name);
	}
}
