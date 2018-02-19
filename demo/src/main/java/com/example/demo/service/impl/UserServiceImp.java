/**
 * 
 */
package com.example.demo.service.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;

/**
 * @author denisputnam
 *
 */
@Service("userService")
@Transactional(value="transactionManager")
public class UserServiceImp implements UserService {
	private final Logger log = Logger.getLogger (this.getClass());
	
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private UserDao userDao;

	@Override
	public User getByEmail(String email) throws Exception {
		String userId = null;
		User user = null;
		try{
			user = userDao.findByEmail(email);
			userId = String.valueOf(user.getId());
		}catch(Exception e){
			log.error("User not found");
			e.printStackTrace();
			throw new Exception(e);
		}
		log.info("The user id is: " + userId);
		return user;
	}

	@Override
	public User create(String email, String name) throws Exception {
		User user = null;
		try{
			user = new User();
			user.setEmail(email);
			user.setName(name);
			userDao.save(user);
		}catch( Exception e ){
			log.error("Error creating the user: " + e.getMessage());
			throw new Exception(e);
		}
		log.info("User id: " + user.getId() + " saved.");
		return user;
	}

	@Override
	public User updateUser(Long id, String email, String name) throws Exception {
		User user = null;
		try{
			user = userDao.findOne(id);
			user.setEmail(email);
			user.setName(name);
			userDao.save(user);
		}catch( Exception e ){
			log.error("Error updating the user: " + e.getMessage());
			throw new Exception(e);
		}
		return user;
	}

	@Override
	public User delete(Long id) throws Exception {
		User user = null;
		try {
			user = userDao.findOne(id);
			userDao.delete(user);
		} catch (Exception e) {
			log.error("Error deleting the user: " + e.getMessage());
			throw new Exception(e);
		}
		return user;
	}

	@Override
	public List<User> findAll() {
		return this.userDao.findAll();
	}

	@Override
	public User findOne(Long id) {
		return this.userDao.findOne(id);
	}

	@Override
	public User create(User user) throws Exception {
		user.setCreatedDate(new Date());
		user.setUpdatedDate(user.getCreatedDate());
		user.setCreatedBy("demo");
		user.setUpdatedBy(user.getCreatedBy());
		user = this.userDao.saveAndFlush(user);
		return user;
	}

	@Override
	public User update(User user) throws Exception {
		user.setUpdatedDate(new Date());
		user.setUpdatedBy("demo");
		user = this.userDao.saveAndFlush(user);
		return user;
	}



}
