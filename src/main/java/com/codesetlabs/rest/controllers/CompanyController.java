package com.codesetlabs.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class CompanyController {

	@Autowired
	CompanyDao companyDao;

	// CREATE
	@RequestMapping(value = "/company/create", method = RequestMethod.POST)

	public @ResponseBody ResponseEntity createCompany(@RequestBody Company company) {

		System.out.println(company.getName());
		try {
			companyDao.save(company);
		} catch (Exception e) {

			return new ResponseEntity<>(company, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(company, HttpStatus.OK);
	}

	// Update
	@RequestMapping(value = "/company/update/", method = RequestMethod.PATCH)

	public @ResponseBody ResponseEntity updateCompany(@RequestBody Company company) {

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
	@RequestMapping(value = "/company/delete/{id}", method = RequestMethod.DELETE)

	public @ResponseBody ResponseEntity deleteCompany(@PathVariable int id) {

		Company deleted = null;
		try {
			deleted = companyDao.findOne(id);
			companyDao.delete(id);

		} catch (Exception e) {

			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(deleted, HttpStatus.OK);
	}
	
	
	
	// Get
		@RequestMapping(value = "/company/{id}", method = RequestMethod.GET)

		public @ResponseBody Company getCompany(@PathVariable int id) {

			Company c = null;
			try {
				c = companyDao.findOne(id);
				System.out.println(c.getUsers().toArray().length);
				

			} catch (Exception e) {

				return null;
			}

			return c;
		}

}
