package com.codesetlabs.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class UserController {

	@Autowired
	UserDao userDao;

	@Autowired
	CompanyDao companyDao;

	// CREATE
	@RequestMapping(value = "/user/create", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity createUser(@RequestBody User user) {

		try {
			Company company = companyDao.findOne(user.getCompany().getId());
			user.setCompany(company);
			userDao.save(user);

		} catch (Exception e) {

			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	// Update
	@RequestMapping(value = "/user/update/", method = RequestMethod.PATCH)
	public @ResponseBody ResponseEntity updateUser(@RequestBody Company company) {

		System.out.println(company.getName());
		try {
			Company edited = companyDao.findOne(company.getId());
			edited.setName(company.getName());
			companyDao.save(edited);

		} catch (Exception e) {

			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(company, HttpStatus.OK);
	}

	 // Delete
	 @RequestMapping(value = "/user/delete/{id}", method =
	 RequestMethod.DELETE)
	
	 public @ResponseBody ResponseEntity deleteUser(@PathVariable int id) {
	
	 User deleted = null;
	 try {
	 deleted = userDao.findOne(id);
	 userDao.delete(id);
	
	 } catch (Exception e) {
	
	 return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
	 }
	
	 return new ResponseEntity<>(deleted, HttpStatus.OK);
	 }
	

	
	// Get
		@RequestMapping(value = "/user/company/{id}", method = RequestMethod.GET)
		public @ResponseBody List<User> getUsersbyCompany(@PathVariable int id) {

			List<User> c = null;
			try {
				Company company = companyDao.findOne(id);
				c = userDao.findByCompany(company);

			} catch (Exception e) {

				return null;
			}

			return c;
		}
		
		
		
	// Get
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public @ResponseBody User getUser(@PathVariable int id) {

		User c = null;
		try {
			c = userDao.findOne(id);

		} catch (Exception e) {

			return null;
		}

		return c;
	}

}
