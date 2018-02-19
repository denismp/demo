/**
 * 
 */
package com.example.demo.service;

import java.util.List;
import java.util.Set;

import com.example.demo.entity.Author;

/**
 * @author denisputnam
 *
 */
public interface AuthorService {
	public Set<Author> getByAuthorName( String name );
	public Author create( Author author ) throws Exception;
	public Author update( Author author ) throws Exception;
	public Author create( String name ) throws Exception;
	public Author create( String name, String bookTitle ) throws Exception;
	public Author updateAuthor( Long id, String name ) throws Exception;
	public Author delete( Long id ) throws Exception;
	public List<Author> findAll();
	public Author findOne( Long id );
	public List<Author> getAuthorsByBook(String book);
}
