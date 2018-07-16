package yk.tut.Mongo_H2_Rest.comments;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import yk.tut.Mongo_H2_Rest.person.Person;

/**
 * 
 * @author Karavasilis Ioannis
 *
 */
@Repository
public interface CommentRepository extends MongoRepository<Comment, String> {

	public List<Comment> findByPerson(Person person);
}
