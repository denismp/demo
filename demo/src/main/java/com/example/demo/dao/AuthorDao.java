/**
 * 
 */
package com.example.demo.dao;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Author;

/**
 * @author denisputnam
 *
 */
public interface AuthorDao extends JpaRepository<Author, Long> {
    @Query("SELECT a FROM Author a WHERE a.name = ?1")
	public Set<Author> getByName( String name );
}
