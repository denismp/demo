/**
 * 
 */
package com.example.demo.controller;

import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Author;
import com.example.demo.service.AuthorService;
import com.example.demo.view.model.AuthorView;
import com.example.demo.view.service.AuthorViewService;

/**
 * @author denisputnam
 *
 */
@RestController
@RequestMapping( value = "/" )
public class AuthorController {
	private final Logger log = Logger.getLogger (this.getClass());
	
	@Autowired
	private AuthorService authorService;
	
	@Autowired
	private AuthorViewService authorViewService;
	
	@ResponseBody
	@RequestMapping(value = { "/authors" }, method = { RequestMethod.GET })
	public ResponseEntity<List<AuthorView>> getAuthors() {
		log.info("getAuthors(): Called...");

		List<Author> authors = null;


		authors = this.authorService.findAll();
		List<AuthorView> authorViewList = this.authorViewService.convertAuthorList(authors);

		if (authors == null || authors.isEmpty()) {
			log.info("getAuthors(): returned a null or empty list."); 
			ResponseEntity<List<AuthorView>> rVal = new ResponseEntity<List<AuthorView>>(authorViewList, HttpStatus.NO_CONTENT);
			return rVal;
		}
		return new ResponseEntity<List<AuthorView>>(authorViewList, HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping(value = { "/authors/books/{title}" }, method = { RequestMethod.GET })
	public ResponseEntity<List<AuthorView>> getAuthorsByBook(@PathVariable String title) {
		log.info("getAuthorsByBook(): Called...");

		List<Author> authors = null;

		authors = this.authorService.getAuthorsByBook(title);
		List<AuthorView> authorViewList = this.authorViewService.convertAuthorList(authors);

		if (authors == null || authors.isEmpty()) {
			log.info("getAuthorsByBook(): returned a null or empty list."); 
			ResponseEntity<List<AuthorView>> rVal = new ResponseEntity<List<AuthorView>>(authorViewList, HttpStatus.NO_CONTENT);
			return rVal;
		}
		return new ResponseEntity<List<AuthorView>>(authorViewList, HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping(value = { "/authors/name/{name}" }, method = { RequestMethod.GET })
	public ResponseEntity<List<AuthorView>> getAuthorsByName(@PathVariable String name) {
		log.info("getAuthorsByName(): Called...");

		Set<Author> authors = null;

		authors = this.authorService.getByAuthorName(name);
		List<AuthorView> authorViewList = this.authorViewService.convertAuthorList(authors);

		if (authors == null || authors.isEmpty()) {
			log.info("getBooksByTitle(): returned a null or empty list."); 
			ResponseEntity<List<AuthorView>> rVal = new ResponseEntity<List<AuthorView>>(authorViewList, HttpStatus.NO_CONTENT);
			return rVal;
		}
		return new ResponseEntity<List<AuthorView>>(authorViewList, HttpStatus.OK);
	}

//	create(String name, String title) 
	@ResponseBody
	@RequestMapping( value = {"/create/author/{name}/{title}"}, method = { RequestMethod.POST})
	public ResponseEntity<Author> createAuthor(@PathVariable String name, @PathVariable String title ){
		Author author = null;
		try{
			author = authorService.create(name, title);
			if( author.getId() == 0 ){
				log.error("Author already exists for: " + name);
				ResponseEntity<Author> rVal = new ResponseEntity<Author>(author, HttpStatus.BAD_REQUEST);
				return rVal;				
			}
		}catch( Exception e ) {
			log.error("Error creating the book: " + e.toString());
			ResponseEntity<Author> rVal = new ResponseEntity<Author>(author, HttpStatus.BAD_REQUEST);
			return rVal;
		}
		return new ResponseEntity<Author>(author, HttpStatus.OK);
	}

	@ResponseBody
	@RequestMapping( value = {"/create/author"}, method = { RequestMethod.POST})
	public ResponseEntity<Author> createAuthor(@RequestBody Author author ){
		try{
			author = authorService.create(author);
			if( author.getId() == 0 ){
				log.error("Author already exists for: " + author.getName());
				ResponseEntity<Author> rVal = new ResponseEntity<Author>(author, HttpStatus.BAD_REQUEST);
				return rVal;				
			}
		}catch( Exception e ) {
			log.error("Error creating the book: " + e.toString());
			ResponseEntity<Author> rVal = new ResponseEntity<Author>(author, HttpStatus.BAD_REQUEST);
			return rVal;
		}
		return new ResponseEntity<Author>(author, HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping( value = {"/create/author/{name}"}, method = { RequestMethod.POST})
	public ResponseEntity<Author> createAuthor(@PathVariable String name ){
		Author author = null;
		try{
			author = authorService.create(name);
			if( author.getId() == 0 ){
				log.error("Author already exists for: " + name);
				ResponseEntity<Author> rVal = new ResponseEntity<Author>(author, HttpStatus.BAD_REQUEST);
				return rVal;				
			}
		}catch( Exception e ) {
			log.error("Error creating the book: " + e.toString());
			ResponseEntity<Author> rVal = new ResponseEntity<Author>(author, HttpStatus.BAD_REQUEST);
			return rVal;
		}
		return new ResponseEntity<Author>(author, HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping( value = {"/delete/author/{id}"}, method = { RequestMethod.DELETE})
	public ResponseEntity<Author> deleteAuthor( @PathVariable long id ){
		Author author = null;
		try{
			author = authorService.delete(id);
		}catch( Exception e ) {
			log.error("Error deleting the book: " + e.toString());
			ResponseEntity<Author> rVal = new ResponseEntity<Author>(author, HttpStatus.BAD_REQUEST);
			return rVal;
		}
		return new ResponseEntity<Author>(author, HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping( value = {"/update/author/{id}/{name}"}, method = { RequestMethod.PUT})
	public ResponseEntity<Author> updateAuthor( @PathVariable long id, @PathVariable String title, @PathVariable String name  ){
		Author author = null;
		try{
			author = authorService.findOne(id);
			if( author == null ){
				log.info("Author not found for id=" + id );
				ResponseEntity<Author> rVal = new ResponseEntity<Author>(author, HttpStatus.NO_CONTENT);
				return rVal;
			}else{
				
				author = authorService.updateAuthor(id, name);
			}
		}catch( Exception e ) {
			log.error("Error updating the book: " + e.toString());
			ResponseEntity<Author> rVal = new ResponseEntity<Author>(author, HttpStatus.BAD_REQUEST);
			return rVal;
		}
		return new ResponseEntity<Author>(author, HttpStatus.OK);
	}

}
