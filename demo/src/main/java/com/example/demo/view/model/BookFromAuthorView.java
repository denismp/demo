/**
 * 
 */
package com.example.demo.view.model;

import java.util.Date;
import com.example.demo.entity.User;

/**
 * @author denisputnam
 *
 */
public class BookFromAuthorView extends History {

	/**
	 * 
	 */
	private static final long serialVersionUID = -18626776332908201L;
	
	private Long id;
	private String title;
	private User user;
	private Date publishDate;

	/**
	 * @return the publishDate
	 */
	public Date getPublishDate() {
		return publishDate;
	}

	/**
	 * @param publishDate the publishDate to set
	 */
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

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
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
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
