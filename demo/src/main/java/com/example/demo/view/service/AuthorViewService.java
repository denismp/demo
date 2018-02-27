/**
 * 
 */
package com.example.demo.view.service;

import java.util.List;
import java.util.Set;

import com.example.demo.entity.Author;
import com.example.demo.view.model.AuthorView;

/**
 * @author denisputnam
 *
 */
public interface AuthorViewService {
	public AuthorView convertAuthor( Author author );
	public List<AuthorView> convertAuthorList( List<Author> authors );
	public List<AuthorView> convertAuthorList(Set<Author> authors);
}
