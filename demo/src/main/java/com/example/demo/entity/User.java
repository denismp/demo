package com.example.demo.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
//import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
//@Table(name = "users")
@Table(
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"email"})
        }
)
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -507606192667894785L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotNull
	private String email;
	
	@NotNull
	private String name;
	
	@OneToMany(fetch=FetchType.LAZY)
	Set<Book> books;
	

	/**
	 * @return the books
	 */
	public Set<Book> getBooks() {
		return books;
	}


	/**
	 * @param books the books to set
	 */
	public void setBooks(Set<Book> books) {
		this.books = books;
	}


	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}


	public long getId() {
		return id;
	}


	public long setId(long value) {
		return id = value;
	}


	public String getEMail() {
		return email;
	}


	public void setEmail(String value) {
		email = value;

	}


	public String getName() {
		return name;
	}


	public void setName(String value) {
		name = value;

	}


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		return result;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}

}
