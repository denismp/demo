/**
 * 
 */
package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Book;

/**
 * @author denisputnam
 *
 */
public interface BookService {
	public List<Book> getByAuthorName( String name );
	public List<Book> getByTitle( String title );
	public Book create( String title, String author ) throws Exception;
	public Book updateBook( Long id, String title, String author ) throws Exception;
	public Book delete( Long id ) throws Exception;
	public List<Book> findAll();
	public Book findOne( Long id );
}
