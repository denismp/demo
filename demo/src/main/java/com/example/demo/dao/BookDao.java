/**
 * 
 */
package com.example.demo.dao;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Book;

/**
 * @author denisputnam
 *
 */
@Transactional
@Repository
public interface BookDao extends JpaRepository<Book, Long> {
//    @Query("SELECT b FROM Book b WHERE b.authorName = ?1")
//	public List<Book> getByAuthor( String author );
    
    @Query("SELECT b FROM Book b WHERE b.title = ?1")
	public Set<Book> getByTitle( String title );
}
