package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
//@Table(name = "book")
//@Table(
//      uniqueConstraints = {
//              @UniqueConstraint(columnNames = {"title"})
//      }
//)
public class Book implements BookInterface {
	
	private static final long serialVersionUID = -9019470250770543773L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private String title;
	
	@Column
	private Long authorId;
	
	@Column
	private String authorName;

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
	 * @return the authorId
	 */
	public Long getAuthorId() {
		return authorId;
	}

	/**
	 * @param authorId the authorId to set
	 */
	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return this.title;
	}

	@Override
	public String getAuthorName() {
		// TODO Auto-generated method stub
		return this.authorName;
	}

	@Override
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
		
	}

	@Override
	public void setTitle(String title) {
		this.title = title;
		
	}


}