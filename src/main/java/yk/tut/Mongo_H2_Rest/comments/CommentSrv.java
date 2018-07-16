package yk.tut.Mongo_H2_Rest.comments;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import yk.tut.Mongo_H2_Rest.person.Person;

/**
 * 
 * @author Karavasilis Ioannis
 *
 */
@Service
public final class CommentSrv {
	
	private CommentRepository commentRepo;
	
	public CommentSrv(CommentRepository commentRepo) {
		this.commentRepo = commentRepo;
	}
	
	public Comment findById(String id) {
		return commentRepo.findById(id).orElse(null);
	}

	public List<Comment> findByPerson(Person person){
		List<Comment> comments = commentRepo.findByPerson(person);
		return comments.isEmpty() ? Collections.emptyList() : comments;
	}
	
	public List<Comment> findAll(){
		return commentRepo.findAll();
	}
	
	public Comment save(Comment comment) {
		return commentRepo.save(comment);
	}
}
