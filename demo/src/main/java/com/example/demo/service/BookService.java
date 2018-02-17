/**
 * 
 */
package com.example.demo.service;

import java.util.List;
import java.util.Set;

import com.example.demo.entity.Book;

/**
 * @author denisputnam
 *
 */
public interface BookService {
	public Set<Book> getByTitle( String title );
	public Book create( String title, String author ) throws Exception;
	public Book updateBook( Long id, String title, String author ) throws Exception;
	public Book delete( Long id ) throws Exception;
	public List<Book> findAll();
	public Book findOne( Long id );
	public Set<Book> getByAuthorName(String author);
	public Book updateBookUser(Long id, String userEmail, String name) throws Exception;
}
