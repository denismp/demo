/**
 * 
 */
package com.example.demo.view.model;

import java.util.Date;
import java.util.Set;

/**
 * @author denisputnam
 *
 */
public class AuthorView extends History {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5412409049571175720L;
	
	private Long id;
	private String name;	
	private Set<BookFromAuthorView> books;
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the books
	 */
	public Set<BookFromAuthorView> getBooks() {
		return books;
	}
	/**
	 * @param books the books to set
	 */
	public void setBooks(Set<BookFromAuthorView> books) {
		this.books = books;
	}
	@Override
	public String getCreatedBy() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Date getCreatedDate() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setCreatedDate(Date createdDate) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String getUpdatedBy() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setUpdatedBy(String updatedBy) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Date getUpdatedDate() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setUpdatedDate(Date updatedDate) {
		// TODO Auto-generated method stub
		
	}

}
