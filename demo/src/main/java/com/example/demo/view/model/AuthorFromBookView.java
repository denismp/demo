/**
 * 
 */
package com.example.demo.view.model;

import java.util.Date;

/**
 * @author denisputnam
 *
 */
public class AuthorFromBookView extends History {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1815977528909560572L;
	
	private Long id;
	private String name;	

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
