package yk.tut.Mongo_H2_Rest.person;

import java.util.List;

import org.springframework.stereotype.Service;

/**
 * 
 * @author Karavasilis Ioannis
 *
 */
@Service
public final class PersonSrv {

	private PersonRepository personRepo;
	
	public PersonSrv(PersonRepository personRepo) {
		this.personRepo = personRepo;
	}
	
	public Person findById(Long id) {
		return personRepo.findById(id).orElse(null);
	}
	
	public List<Person> findAll(){
		return personRepo.findAll();
	}
	
	public Person save(Person person) {
		return personRepo.save(person);
	}
}
