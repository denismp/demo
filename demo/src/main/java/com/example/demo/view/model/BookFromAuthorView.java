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

	/* (non-Javadoc)
	 * @see com.example.demo.view.History#getCreatedBy()
	 */
	@Override
	public String getCreatedBy() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.example.demo.view.History#getCreatedDate()
	 */
	@Override
	public Date getCreatedDate() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.example.demo.view.History#setCreatedDate(java.util.Date)
	 */
	@Override
	public void setCreatedDate(Date createdDate) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.example.demo.view.History#getUpdatedBy()
	 */
	@Override
	public String getUpdatedBy() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.example.demo.view.History#setUpdatedBy(java.lang.String)
	 */
	@Override
	public void setUpdatedBy(String updatedBy) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.example.demo.view.History#getUpdatedDate()
	 */
	@Override
	public Date getUpdatedDate() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.example.demo.view.History#setUpdatedDate(java.util.Date)
	 */
	@Override
	public void setUpdatedDate(Date updatedDate) {
		// TODO Auto-generated method stub

	}

}
