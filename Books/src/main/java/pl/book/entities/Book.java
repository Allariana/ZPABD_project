package pl.book.entities;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.data.jpa.repository.Query;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long book_id;
	private String title;
	
	@JsonBackReference
	@ManyToOne
	private Author author;
	
	@JsonBackReference
	@ManyToOne
	private Type type;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "book")
	Set<Mark> marks;
	
	private Double averageMark;
	

	public Double getAverageMark() {
		return averageMark;
	}
	public void setAverageMark(Double averageMark) {
		this.averageMark = averageMark;
	}
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getBook_id() {
		return book_id;
	}
	public void setBook_id(Long book_id) {
		this.book_id = book_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	
}
