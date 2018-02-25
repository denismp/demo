/**
 * 
 */
package com.example.demo.view.service;

import java.util.List;

import com.example.demo.entity.Author;
import com.example.demo.view.model.AuthorView;

/**
 * @author denisputnam
 *
 */
public interface AuthorViewService {
	public AuthorView convertAuthor( Author author );
	public List<AuthorView> convertAuthorList( List<Author> authors );
}
