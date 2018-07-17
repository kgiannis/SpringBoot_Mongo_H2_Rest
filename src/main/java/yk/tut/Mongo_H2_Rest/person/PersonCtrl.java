package yk.tut.Mongo_H2_Rest.person;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author Karavasilis Ioannis
 *
 */
@RestController
@RequestMapping("/api/person")
public final class PersonCtrl {
	
	private PersonSrv personSrv;
	
	public PersonCtrl(PersonSrv personSrv) {
		this.personSrv = personSrv;
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> find(@PathVariable Long id){
		Person person = personSrv.findById(id);
		if(person == null) {
			return new ResponseEntity<String>("Person not found.", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Person>(person, HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity<?> findAll(){
		List<Person> persons = personSrv.findAll();
		if(persons.isEmpty()) {
			return new ResponseEntity<String>("Person TABLE is empty.", HttpStatus.OK);
		}
		return new ResponseEntity<List<Person>>(persons, HttpStatus.OK);
	}
	
	@PutMapping("/")
	public ResponseEntity<?> create(@RequestBody Person person){
		if(person == null) {
			return new ResponseEntity<String>("Person is NULL.", HttpStatus.BAD_REQUEST);
		}
		personSrv.save(person);
		return new ResponseEntity<Person>(person, HttpStatus.OK);
	}
	
}
