/**
 * 
 */
package com.example.demo.service.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.AuthorDao;
import com.example.demo.dao.BookDao;
import com.example.demo.entity.Author;
import com.example.demo.entity.Book;
import com.example.demo.entity.User;
import com.example.demo.service.AuthorService;
import com.example.demo.service.BookService;
import com.example.demo.service.UserService;

/**
 * @author denisputnam
 *
 */
@Service("bookService")
@Transactional(value="transactionManager")
public class BookServiceImpl implements BookService {
	private final Logger log = Logger.getLogger (this.getClass());
	
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private BookDao bookDao;
	
	@Autowired
	private AuthorDao authorDao;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AuthorService authorService;


	/* (non-Javadoc)
	 * @see com.example.demo.service.BookService#getByTitle(java.lang.String)
	 */
	@Override
	public Set<Book> getByTitle(String title) {
		return this.bookDao.getByTitle(title);
	}

	/* (non-Javadoc)
	 * @see com.example.demo.service.BookService#create(java.lang.String, java.lang.String)
	 */
	@Override
	public Book create(String author, Book book) throws Exception {
		try {
			Set<Author> authors = this.authorDao.getByName(author);
			if( authors == null || authors.isEmpty() == true ) {
				authors = new HashSet<Author>();
				Author myAuthor = new Author();
				myAuthor.setName(author);
				myAuthor = this.authorService.create(author);
//				myAuthor = this.authorDao.saveAndFlush(myAuthor);
				authors.add(myAuthor);
			}
			book.setAuthors(new HashSet<Author>(authors));
			
//			this.bookDao.saveAndFlush(book);
			book = this.create(book);
			for( Author myAuthor: authors ) {
				Set<Book> books = myAuthor.getBooks();
				if( books == null ) {
					books = new HashSet<Book>();
					books.add(book);
					myAuthor.setBooks(books);
				} else {
					books.add(book);
					myAuthor.setBooks(books);
				}
				this.authorDao.saveAndFlush(myAuthor);
			}
		}catch( Exception e ) {
			log.error("Error creating book: " + e.getMessage());
			throw new Exception(e);
		}

		return book;
	}

	/* (non-Javadoc)
	 * @see com.example.demo.service.BookService#updateBook(java.lang.Long, java.lang.String, java.lang.String)
	 */
	@Override
	public Book updateBook(Long id, String title, String author) throws Exception {
		Book book = null;
		try{
			book = bookDao.findOne(id);
			book.setTitle(title);
			Set<Author> authors = book.getAuthors();
			if( authors == null || authors.isEmpty() == true ) {
				authors = new HashSet<Author>();
				Author myAuthor = new Author();
				myAuthor.setName(author);
				myAuthor = this.authorService.create(author);
//				this.authorDao.saveAndFlush(myAuthor);
				authors.add(myAuthor);
			} else {
				authors.addAll(this.authorDao.getByName(author));
			}
			book.setAuthors(authors);

//			bookDao.saveAndFlush(book);
			book = this.update(book);
		}catch( Exception e ){
			log.error("Error updating the book: " + e.getMessage());
			throw new Exception(e);
		}
		return book;
	}

	/* (non-Javadoc)
	 * @see com.example.demo.service.BookService#delete(java.lang.Long)
	 */
	@Override
	public Book delete(Long id) throws Exception {
		Book book = null;
		try {
			book = bookDao.findOne(id);
			bookDao.delete(book);
		} catch (Exception e) {
			log.error("Error deleting the book: " + e.getMessage());
			throw new Exception(e);
		}
		return book;
	}

	/* (non-Javadoc)
	 * @see com.example.demo.service.BookService#findAll()
	 */
	@Override
	public List<Book> findAll() {
		return this.bookDao.findAll();
	}

	/* (non-Javadoc)
	 * @see com.example.demo.service.BookService#findOne(java.lang.Long)
	 */
	@Override
	public Book findOne(Long id) {
		return this.bookDao.findOne(id);
	}

	/*
	 * (non-Javadoc)
	 * @see com.example.demo.service.BookService#getByAuthorName(java.lang.String)
	 */
	@Override
	public Set<Book> getByAuthorName(String name) {
		Set<Author> authors = this.authorDao.getByName(name);
		Set<Book> list = new HashSet<Book>();
		for( Author author: authors ) {
			if( author.getBooks() != null )
				list.addAll(author.getBooks());			
		}
		return list;
	}

	@Override
	public Book updateBookUser(Long id,  String userEmail, String name ) throws Exception {
		Book book = null;
		try{
			book = bookDao.findOne(id);
			User user = book.getUser();
			if( user == null ) {
				user = new User();
				user.setEmail(userEmail);
				user.setName( name );
				user = this.userService.create(user);
//				user = this.userDao.saveAndFlush(user);
			} else {
				user = this.userService.getByEmail(userEmail);
			}
			Set<Book> books = user.getBooks();
			books.add(book);
			user.setBooks(books);
			book.setUser(user);
			
			book = this.update(book);
//			bookDao.saveAndFlush(book);
		}catch( Exception e ){
			log.error("Error updating the book: " + e.getMessage());
			throw new Exception(e);
		}
		return book;
	}

	@Override
	public Book create(Book book) throws Exception {
		book.setCreatedDate(new Date());
		book.setUpdatedDate(book.getCreatedDate());
		book.setCreatedBy("demo");
		book.setUpdatedBy(book.getCreatedBy());
		book = this.bookDao.saveAndFlush(book);
		return book;
	}

	@Override
	public Book update(Book book) throws Exception {
		book.setUpdatedDate(new Date());
		book.setUpdatedBy("demo");
		book = this.bookDao.saveAndFlush(book);
		return book;
	}

}
