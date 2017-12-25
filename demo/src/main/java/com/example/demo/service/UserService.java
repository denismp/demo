/**
 * 
 */
package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.User;

/**
 * @author denisputnam
 *
 */
public interface UserService {
	public User getByEmail( String email ) throws Exception;
	public User create( String email, String name ) throws Exception;
	public User updateUser( Long id, String email, String name ) throws Exception;
	public User delete( Long id ) throws Exception;
	public List<User> findAll();
	public User findOne( Long id );
}
