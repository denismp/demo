/**
 * 
 */
package com.example.demo.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Book;
import com.example.demo.service.BookService;

/**
 * @author denisputnam
 *
 */
@RestController
public class BookController {
	private final Logger log = Logger.getLogger (this.getClass());
	
	@Autowired
	private BookService bookService;
	
	@ResponseBody
	@RequestMapping(value = { "/books" }, method = { RequestMethod.GET })
	public ResponseEntity<List<Book>> getBooks() {
		log.info("getBooks(): Called...");

		List<Book> books = null;

		books = this.bookService.findAll();

		if (books == null || books.isEmpty()) {
			log.info("getBooks(): returned a null or empty list."); 
			ResponseEntity<List<Book>> rVal = new ResponseEntity<List<Book>>(books, HttpStatus.NO_CONTENT);
			return rVal;
		}
		return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping(value = { "/books/{author}" }, method = { RequestMethod.GET })
	public ResponseEntity<List<Book>> getBooksByAuthor(@PathVariable String author) {
		log.info("getBooksByAuthor(): Called...");

		List<Book> books = null;

		books = this.bookService.getByAuthorName(author);

		if (books == null || books.isEmpty()) {
			log.info("getBooksByAuthor(): returned a null or empty list."); 
			ResponseEntity<List<Book>> rVal = new ResponseEntity<List<Book>>(books, HttpStatus.NO_CONTENT);
			return rVal;
		}
		return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping(value = { "/books/{title}" }, method = { RequestMethod.GET })
	public ResponseEntity<List<Book>> getBooksByTitle(@PathVariable String title) {
		log.info("getBooksByTitle(): Called...");

		List<Book> books = null;

		books = this.bookService.getByTitle(title);

		if (books == null || books.isEmpty()) {
			log.info("getBooksByTitle(): returned a null or empty list."); 
			ResponseEntity<List<Book>> rVal = new ResponseEntity<List<Book>>(books, HttpStatus.NO_CONTENT);
			return rVal;
		}
		return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
	}
	
	
	@ResponseBody
	@RequestMapping( value = {"/create/{title}/{author}"}, method = { RequestMethod.POST})
	public ResponseEntity<Book> createBook( @PathVariable String title, @PathVariable String author ){
		Book book = null;
		try{
			book = bookService.create(title, author);
			if( book.getId() == 0 ){
				log.error("Book already exists for: " + title);
				ResponseEntity<Book> rVal = new ResponseEntity<Book>(book, HttpStatus.BAD_REQUEST);
				return rVal;				
			}
		}catch( Exception e ) {
			log.error("Error creating the book: " + e.toString());
			ResponseEntity<Book> rVal = new ResponseEntity<Book>(book, HttpStatus.BAD_REQUEST);
			return rVal;
		}
		return new ResponseEntity<Book>(book, HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping( value = {"/delete/book/{id}"}, method = { RequestMethod.DELETE})
	public ResponseEntity<Book> deleteBook( @PathVariable long id ){
		Book book = null;
		try{
			book = bookService.delete(id);
		}catch( Exception e ) {
			log.error("Error deleting the book: " + e.toString());
			ResponseEntity<Book> rVal = new ResponseEntity<Book>(book, HttpStatus.BAD_REQUEST);
			return rVal;
		}
		return new ResponseEntity<Book>(book, HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping( value = {"/update/{id}/{title}/{author}"}, method = { RequestMethod.PUT})
	public ResponseEntity<Book> updateBook( @PathVariable long id, @PathVariable String title, @PathVariable String author  ){
		Book book = null;
		try{
			book = bookService.findOne(id);
			if( book == null ){
				log.info("Book not found for id=" + id );
				ResponseEntity<Book> rVal = new ResponseEntity<Book>(book, HttpStatus.NO_CONTENT);
				return rVal;
			}else{
				book = bookService.updateBook(id, title, author);
			}
		}catch( Exception e ) {
			log.error("Error updating the book: " + e.toString());
			ResponseEntity<Book> rVal = new ResponseEntity<Book>(book, HttpStatus.BAD_REQUEST);
			return rVal;
		}
		return new ResponseEntity<Book>(book, HttpStatus.OK);
	}

}
