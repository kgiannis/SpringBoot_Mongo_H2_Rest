package yk.tut.Mongo_H2_Rest.comments;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import yk.tut.Mongo_H2_Rest.person.Person;

/**
 * 
 * @author Karavasilis Ioannis
 *
 */
@Document(collection = "comment")
public final class Comment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private String message;
	private Person person;
	
	public Comment() {}

	public Comment(String message) {
		this.message = message;
	}

	public Comment(String id, String message, Person person) {
		this.id = id;
		this.message = message;
		this.person = person;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
}
