package yk.tut.Mongo_H2_Rest.person;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author Karavasilis Ioannis
 *
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

	public Optional<Person> findById(Long id);
}
