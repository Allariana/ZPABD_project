package pl.book.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String LastName;
	private String FirstName;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "author")
	Set<Book> books;
	
	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Author(Long id, String lastName, String firstName) {
		super();
		this.id = id;
		LastName = lastName;
		FirstName = firstName;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public Set<Book> getBooks() {
		return books;
	}
	public void setBooks(Set<Book> books) {
		this.books = books;
	}
	@Override
	public String toString() {
		return "Author [id=" + id + ", LastName=" + LastName + ", FirstName=" + FirstName + "]";
	}
	
}
