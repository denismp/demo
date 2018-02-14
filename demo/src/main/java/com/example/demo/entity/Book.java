package com.example.demo.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
// @Table(name = "book")
// @Table(
// uniqueConstraints = {
// @UniqueConstraint(columnNames = {"title"})
// }
// )
// public class Book implements BookInterface {
public class Book extends History implements Serializable {

	private static final long serialVersionUID = -9019470250770543773L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column
	private String title;


	@ManyToMany(fetch=FetchType.LAZY)
	private Set<Author> authors;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private User user;

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

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}


	public void setTitle(String title) {
		this.title = title;

	}

	
	/**
	 * @return the authors
	 */
	public Set<Author> getAuthors() {
		return authors;
	}

	/**
	 * @param authors the authors to set
	 */
	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}

}