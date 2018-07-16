package yk.tut.Mongo_H2_Rest.comments;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import yk.tut.Mongo_H2_Rest.person.Person;
import yk.tut.Mongo_H2_Rest.person.PersonSrv;

/**
 * 
 * @author Karavasilis Ioannis
 *
 */
@RestController
@RequestMapping("api/comment")
public final class CommentCtrl {

	private CommentSrv commentSrv;
	private PersonSrv personSrv;
	
	public CommentCtrl(CommentSrv commentSrv, PersonSrv personSrv) {
		this.commentSrv = commentSrv;
		this.personSrv = personSrv;
	}
	
	@GetMapping("/find")
	public ResponseEntity<?> findAll(){
		return new ResponseEntity<List<Comment>>(commentSrv.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/find/{personId}")
	public ResponseEntity<?> findByPerson(@PathVariable Long personId){
		Person person = personSrv.findById(personId);
		if(person == null) {
			return new ResponseEntity<String>("Person not found.", HttpStatus.NOT_FOUND);
		}
		List<Comment> comments = commentSrv.findByPerson(person);
		return new ResponseEntity<List<Comment>>(comments, HttpStatus.OK);
	}
	
	@PostMapping("/create/{message}")
	public ResponseEntity<?> create(@PathVariable String message){
		Comment comment = new Comment(message);
		commentSrv.save(comment);
		return new ResponseEntity<Comment>(comment, HttpStatus.OK);
	}
	
	@PostMapping("{commentId}/setPerson/{personId}")
	public ResponseEntity<?> setPersonOnComment(@PathVariable String commentId, @PathVariable Long personId){
		Comment comment = commentSrv.findById(commentId);
		if(comment == null) {
			return new ResponseEntity<String>("Comment not found.", HttpStatus.NOT_FOUND);
		}
		Person person = personSrv.findById(personId);
		if(person == null) {
			return new ResponseEntity<String>("Person not found.", HttpStatus.NOT_FOUND);
		}
		comment.setPerson(person);
		commentSrv.save(comment);
		return new ResponseEntity<Comment>(comment, HttpStatus.OK);
	}
}
