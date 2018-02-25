/**
 * 
 */
package com.example.demo.view.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Author;
import com.example.demo.entity.Book;
import com.example.demo.view.model.AuthorView;
import com.example.demo.view.model.BookFromAuthorView;
import com.example.demo.view.service.AuthorViewService;

/**
 * @author denisputnam
 *
 */
@Service( "authorViewService" )
public class AuthorViewServiceImpl implements AuthorViewService {

	/* (non-Javadoc)
	 * @see com.example.demo.view.service.AuthorViewService#convertAuthor(com.example.demo.entity.Author)
	 */
	@Override
	public AuthorView convertAuthor(Author author) {
		AuthorView viewObject = new AuthorView();
		viewObject.setCreatedBy(author.getCreatedBy());
		viewObject.setCreatedDate(author.getCreatedDate());
		viewObject.setId(author.getId());
		viewObject.setName(author.getName());
		viewObject.setUpdatedBy(author.getUpdatedBy());
		viewObject.setUpdatedDate(author.getUpdatedDate());
		Set<BookFromAuthorView> books = new HashSet<BookFromAuthorView>();
		for( Book book: author.getBooks() ) {
			BookFromAuthorView bookFromAuthorView = new BookFromAuthorView();
			bookFromAuthorView.setCreatedBy(book.getCreatedBy());
			bookFromAuthorView.setCreatedDate(book.getCreatedDate());
			bookFromAuthorView.setId(book.getId());
			bookFromAuthorView.setTitle(book.getTitle());
			bookFromAuthorView.setUpdatedBy(book.getUpdatedBy());
			bookFromAuthorView.setUpdatedDate(book.getUpdatedDate());
			bookFromAuthorView.setUser(book.getUser());
			books.add(bookFromAuthorView);
		}
		viewObject.setBooks(books);

		return viewObject;
	}

	/* (non-Javadoc)
	 * @see com.example.demo.view.service.AuthorViewService#convertAuthorList(java.util.List)
	 */
	@Override
	public List<AuthorView> convertAuthorList(List<Author> authors) {
		List<AuthorView> viewList = new ArrayList<AuthorView>();
		
		for( Author author: authors ) {
			AuthorView viewObject = this.convertAuthor(author);
			viewList.add(viewObject);
		}
		
		return viewList;
	}

}
