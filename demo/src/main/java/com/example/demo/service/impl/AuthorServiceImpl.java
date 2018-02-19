/**
 * 
 */
package com.example.demo.service.impl;

import java.util.ArrayList;
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
import com.example.demo.service.AuthorService;
import com.example.demo.service.BookService;

/**
 * @author denisputnam
 *
 */
@Service("authorService")
@Transactional(value="transactionManager")
public class AuthorServiceImpl implements AuthorService {
	
	private final Logger log = Logger.getLogger (this.getClass());
	
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private AuthorDao authorDao;
	
	@Autowired
	private BookDao bookDao;
	
	@Autowired
	private BookService bookService;

	/* (non-Javadoc)
	 * @see com.example.demo.service.AuthorService#getByAuthorName(java.lang.String)
	 */
	@Override
	public Set<Author> getByAuthorName(String name) {
		return this.authorDao.getByName(name);
	}

	/* (non-Javadoc)
	 * @see com.example.demo.service.AuthorService#create(java.lang.String)
	 */
	@Override
	public Author create(String name) throws Exception {
		Author author = null;
		try {
			author = new Author();
			author.setName(name);
			author = this.create(author);
//			this.authorDao.saveAndFlush(author);
		}catch( Exception e ) {
			log.error("Error creating author: " + e.getMessage());
			throw new Exception(e);
		}

		return author;
	}

	/* (non-Javadoc)
	 * @see com.example.demo.service.AuthorService#updateAuthor(java.lang.Long, java.lang.String)
	 */
	@Override
	public Author updateAuthor(Long id, String name) throws Exception {
		Author author = null;
		try{
			author = authorDao.findOne(id);
			author.setName(name);
			author = this.update(author);
//			authorDao.saveAndFlush(author);
		}catch( Exception e ){
			log.error("Error updating the author: " + e.getMessage());
			throw new Exception(e);
		}
		return author;
	}

	/* (non-Javadoc)
	 * @see com.example.demo.service.AuthorService#delete(java.lang.Long)
	 */
	@Override
	public Author delete(Long id) throws Exception {
		Author author = null;
		try {
			author = authorDao.findOne(id);
			authorDao.delete(author);
		} catch (Exception e) {
			log.error("Error deleting the author: " + e.getMessage());
			throw new Exception(e);
		}
		return author;
	}

	/* (non-Javadoc)
	 * @see com.example.demo.service.AuthorService#findAll()
	 */
	@Override
	public List<Author> findAll() {
		return this.authorDao.findAll();
	}

	/* (non-Javadoc)
	 * @see com.example.demo.service.AuthorService#findOne(java.lang.Long)
	 */
	@Override
	public Author findOne(Long id) {
		return this.authorDao.findOne(id);
	}

	@Override
	public List<Author> getAuthorsByBook(String title) {
		Set<Book> books = this.bookDao.getByTitle(title);
		List<Author> list = new ArrayList<Author>();
		for( Book book: books ) {
			if( book.getAuthors() != null )
				list.addAll(book.getAuthors());
		}
		return list;
	}

	@Override
	public Author create(String name, String title) throws Exception {
		Author author = null;
		try {
			author = new Author();
			author.setName(name);
			Set<Book> books = this.bookDao.getByTitle(title);
			if( books == null || books.isEmpty() == true ) {
				books = new HashSet<Book>();
				Book myBook = new Book();
				myBook.setTitle(title);
				myBook = this.bookService.update(myBook);
//				myBook = this.bookDao.saveAndFlush(myBook);
				books.add(myBook);
			}
			author.setBooks(books);
			
			this.create(author);
		}catch( Exception e ) {
			log.error("Error creating author: " + e.getMessage());
			throw new Exception(e);
		}

		return author;
	}

	@Override
	public Author create(Author author) throws Exception {
		author.setCreatedDate(new Date());
		author.setUpdatedDate(author.getCreatedDate());
		author.setCreatedBy("demo");
		author.setUpdatedBy(author.getCreatedBy());
		author = this.authorDao.saveAndFlush(author);
		return author;
	}

	@Override
	public Author update(Author author) throws Exception {
		author.setUpdatedBy("demo");
		author.setUpdatedDate(new Date());
		author = this.authorDao.saveAndFlush(author);
		return author;
	}

}
