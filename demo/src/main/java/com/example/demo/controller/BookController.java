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

import com.example.demo.entity.Book;
import com.example.demo.service.BookService;
import com.example.demo.view.model.BookView;
import com.example.demo.view.service.BookViewService;

/**
 * @author denisputnam
 *
 */
@RestController
@RequestMapping( value = "/" )
public class BookController {
	private final Logger log = Logger.getLogger (this.getClass());
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private BookViewService bookViewService;
	
	@ResponseBody
	@RequestMapping(value = { "/books" }, method = { RequestMethod.GET })
	public ResponseEntity<List<BookView>> getBooks() {
		log.info("getBooks(): Called...");

		List<Book> books = null;
		List<BookView> bookViewList = null;

		books = this.bookService.findAll();
		bookViewList = this.bookViewService.convertBookList(books);

		if (books == null || books.isEmpty()) {
			log.info("getBooks(): returned a null or empty list."); 
			ResponseEntity<List<BookView>> rVal = new ResponseEntity<List<BookView>>(bookViewList, HttpStatus.NO_CONTENT);
			return rVal;
		}
		return new ResponseEntity<List<BookView>>(bookViewList, HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping(value = { "/books/author/{name}" }, method = { RequestMethod.GET })
	public ResponseEntity<List<BookView>> getBooksByAuthor(@PathVariable String name) {
		log.info("getBooksByAuthor(): Called...");

		Set<Book> books = null;

		books = this.bookService.getByAuthorName(name);
		List<BookView> bookViewList = this.bookViewService.convertBookList(books);

		if (books == null || books.isEmpty()) {
			log.info("getBooksByAuthor(): returned a null or empty list."); 
			ResponseEntity<List<BookView>> rVal = new ResponseEntity<List<BookView>>(bookViewList, HttpStatus.NO_CONTENT);
			return rVal;
		}
		return new ResponseEntity<List<BookView>>(bookViewList, HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping(value = { "/books/{title}" }, method = { RequestMethod.GET })
	public ResponseEntity<List<BookView>> getBooksByTitle(@PathVariable String title) {
		log.info("getBooksByTitle(): Called...");

		Set<Book> books = null;

		books = this.bookService.getByTitle(title);
		List<BookView> bookViewList = this.bookViewService.convertBookList(books);

		if (books == null || books.isEmpty()) {
			log.info("getBooksByTitle(): returned a null or empty list."); 
			ResponseEntity<List<BookView>> rVal = new ResponseEntity<List<BookView>>(bookViewList, HttpStatus.NO_CONTENT);
			return rVal;
		}
		return new ResponseEntity<List<BookView>>(bookViewList, HttpStatus.OK);
	}
	
	
	@ResponseBody
	@RequestMapping( value = {"/create/book/{author}"}, method = { RequestMethod.POST})
	public ResponseEntity<BookView> createBook( @PathVariable String author, @RequestBody Book book ){
		log.info("createBook(): called with author=" + author);
		BookView bookView = null;
		try{
			book = bookService.create(author, book);
			if( book.getId() == 0L ){
				log.error("Book already exists for: " + author);
				ResponseEntity<BookView> rVal = new ResponseEntity<BookView>(bookView, HttpStatus.BAD_REQUEST);
				return rVal;				
			}
			bookView = this.bookViewService.convertBook(book);
		}catch( Exception e ) {
			log.error("Error creating the book: " + e.toString());
			ResponseEntity<BookView> rVal = new ResponseEntity<BookView>(bookView, HttpStatus.BAD_REQUEST);
			return rVal;
		}
		log.info("createBook(): successfully created the book.");
		return new ResponseEntity<BookView>(bookView, HttpStatus.OK);
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
	@RequestMapping( value = {"/update/book/{id}/{title}/{author}"}, method = { RequestMethod.PUT})
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

	@ResponseBody
	@RequestMapping( value = {"/update/book/{id}/{email}/{user}"}, method = { RequestMethod.PUT})
	public ResponseEntity<Book> updateBookUser( @PathVariable long id, @PathVariable String email, @PathVariable String user ){
		Book book = null;
		try{
			book = bookService.findOne(id);
			if( book == null ){
				log.info("Book not found for id=" + id );
				ResponseEntity<Book> rVal = new ResponseEntity<Book>(book, HttpStatus.NO_CONTENT);
				return rVal;
			}else{
				book = bookService.updateBookUser(id, email, user);
			}
		}catch( Exception e ) {
			log.error("Error updating the book: " + e.toString());
			ResponseEntity<Book> rVal = new ResponseEntity<Book>(book, HttpStatus.BAD_REQUEST);
			return rVal;
		}
		return new ResponseEntity<Book>(book, HttpStatus.OK);
	}
}
