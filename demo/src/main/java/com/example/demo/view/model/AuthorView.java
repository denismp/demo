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
		return this.createdBy;
	}
	@Override
	public Date getCreatedDate() {
		return this.createdDate;
	}
	@Override
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	@Override
	public String getUpdatedBy() {
		return this.updatedBy;
	}
	@Override
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;		
	}
	@Override
	public Date getUpdatedDate() {
		return this.updatedDate;
	}
	@Override
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	@Override
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

}
