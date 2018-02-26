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
import com.example.demo.view.model.AuthorFromBookView;
import com.example.demo.view.model.BookView;
import com.example.demo.view.service.BookViewService;

/**
 * @author denisputnam
 *
 */
@Service("bookViewService")
public class BookViewServiceImpl implements BookViewService {

	/* (non-Javadoc)
	 * @see com.example.demo.view.service.BookViewService#convertBook(com.example.demo.entity.Book)
	 */
	@Override
	public BookView convertBook(Book book) {
		BookView viewObject = new BookView();
		viewObject.setCreatedBy(book.getCreatedBy());
		viewObject.setCreatedDate(book.getCreatedDate());
		viewObject.setId(book.getId());
		viewObject.setTitle(book.getTitle());
		viewObject.setUpdatedBy(book.getUpdatedBy());
		viewObject.setUpdatedDate(book.getUpdatedDate());
		viewObject.setUser(book.getUser());
		viewObject.setPublishDate(book.getPublishDate());
		Set<AuthorFromBookView> authors = new HashSet<AuthorFromBookView>();
		for( Author author: book.getAuthors() ) {
			AuthorFromBookView authorFromBookView = new AuthorFromBookView();
			authorFromBookView.setCreatedBy(author.getCreatedBy());
			authorFromBookView.setCreatedDate(author.getCreatedDate());
			authorFromBookView.setId(author.getId());
			authorFromBookView.setName(author.getName());
			authorFromBookView.setUpdatedBy(author.getUpdatedBy());
			authorFromBookView.setUpdatedDate(author.getUpdatedDate());
			authors.add(authorFromBookView);
		}
		viewObject.setAuthors(authors);
		return viewObject;
	}

	/* (non-Javadoc)
	 * @see com.example.demo.view.service.BookViewService#convertBookList(java.util.List)
	 */
	@Override
	public List<BookView> convertBookList(List<Book> list) {
		List<BookView> viewList = new ArrayList<BookView>();
		
		for( Book book: list ) {
			BookView viewObject = this.convertBook(book);
			
			viewList.add(viewObject);
		}

		return viewList;
	}

}
