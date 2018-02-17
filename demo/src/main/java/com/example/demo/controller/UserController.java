package com.example.demo.controller;


import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;



@RestController
@RequestMapping( value = "/" )
public class UserController {
	private final Logger log = Logger.getLogger (this.getClass());
	
	@Autowired
	protected UserService userService;
	
	@ResponseBody
	@RequestMapping(value = { "/users" }, method = { RequestMethod.GET })
	public ResponseEntity<List<User>> getUsers() {
		log.info("getUsers(): Called...");

		List<User> users = null;

		users = this.userService.findAll();

		if (users == null || users.isEmpty()) {
			log.info("getUsers(): returned a null or empty list."); 
			ResponseEntity<List<User>> rVal = new ResponseEntity<List<User>>(users, HttpStatus.NO_CONTENT);
			return rVal;
		}
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping( value = {"/user/get-by-email/{email}"}, method = { RequestMethod.GET})
	public ResponseEntity<User> getUser( @PathVariable String email ){
		User user = null;
		try{
			user = userService.getByEmail(email);
		}catch( Exception e ) {
			log.error("User not found.");
			ResponseEntity<User> rVal = new ResponseEntity<User>(user, HttpStatus.NO_CONTENT);
			return rVal;
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping( value = {"/create/user/{email}/{name}"}, method = { RequestMethod.POST})
	public ResponseEntity<User> createUser( @PathVariable String email, @PathVariable String name ){
		User user = null;
		try{
			user = userService.create(email, name);
			if( user.getId() == 0 ){
				log.error("User already exists for: " + email);
				ResponseEntity<User> rVal = new ResponseEntity<User>(user, HttpStatus.BAD_REQUEST);
				return rVal;				
			}
		}catch( Exception e ) {
			log.error("Error creating the user: " + e.toString());
			ResponseEntity<User> rVal = new ResponseEntity<User>(user, HttpStatus.BAD_REQUEST);
			return rVal;
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping( value = {"/delete/user/{id}"}, method = { RequestMethod.DELETE})
	public ResponseEntity<User> deleteUser( @PathVariable long id ){
		User user = null;
		try{
			user = userService.delete(id);
		}catch( Exception e ) {
			log.error("Error deleting the user: " + e.toString());
			ResponseEntity<User> rVal = new ResponseEntity<User>(user, HttpStatus.BAD_REQUEST);
			return rVal;
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping( value = {"/update/user/{id}/{email}/{name}"}, method = { RequestMethod.PUT})
	public ResponseEntity<User> updateUser( @PathVariable long id, @PathVariable String email, @PathVariable String name  ){
		User user = null;
		try{
			user = userService.findOne(id);
			if( user == null ){
				log.info("User not found for id=" + id );
				ResponseEntity<User> rVal = new ResponseEntity<User>(user, HttpStatus.NO_CONTENT);
				return rVal;
			}else{
				user = userService.updateUser(id, email, name);
			}
		}catch( Exception e ) {
			log.error("Error updating the user: " + e.toString());
			ResponseEntity<User> rVal = new ResponseEntity<User>(user, HttpStatus.BAD_REQUEST);
			return rVal;
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
}