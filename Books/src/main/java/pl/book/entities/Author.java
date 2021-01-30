package pl.book.entities;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String surname;
	private String FirstName;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "author")
	Set<Book> books;
	
	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Author(Long id, String surname, String firstName) {
		super();
		this.id = id;
		this.surname = surname;
		this.FirstName = firstName;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
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
		return "Author [id=" + id + ", surname=" + surname + ", FirstName=" + FirstName + "]";
	}
	
}
