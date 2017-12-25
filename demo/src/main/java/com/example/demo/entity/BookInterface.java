package com.example.demo.entity;

import java.io.Serializable;

public interface BookInterface extends Serializable{
	/**
	 * @return the id
	 */
	public Long getId();

	/**
	 * @param id the id to set
	 */
	public void setId(Long id);
	/**
	 * @return the name
	 */
	public String getTitle();
	
	public String getAuthorName();
	
	public void setAuthorName( String authorName );

	/**
	 * @param name the name to set
	 */
	public void setTitle(String title);

	/**
	 * @return the authorId
	 */
	public Long getAuthorId();

	/**
	 * @param authorId the authorId to set
	 */
	public void setAuthorId(Long authorId);
}