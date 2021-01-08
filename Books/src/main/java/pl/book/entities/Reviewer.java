package pl.book.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Reviewer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long reviewer_id;
	private String LastName;
	private String FirstName;
	private String username;
	private String email;
	
	@OneToMany(mappedBy = "reviewer")
	Set<Mark> marks;
	
	
	public Reviewer() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Reviewer(Long reviewer_id, String lastName, String firstName, String username, String email) {
		super();
		this.reviewer_id = reviewer_id;
		LastName = lastName;
		FirstName = firstName;
		this.username = username;
		this.email = email;
	}


	public Long getReviewer_id() {
		return reviewer_id;
	}


	public void setReviewer_id(Long reviewer_id) {
		this.reviewer_id = reviewer_id;
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


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	
}
