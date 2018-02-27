/**
 * 
 */
package com.example.demo.view.service;

import java.util.List;
import java.util.Set;

import com.example.demo.entity.Book;
import com.example.demo.view.model.BookView;

/**
 * @author denisputnam
 *
 */
public interface BookViewService {
	public BookView convertBook( Book book );
	public List<BookView> convertBookList( List<Book> list );
	public List<BookView> convertBookList(Set<Book> books);
}
