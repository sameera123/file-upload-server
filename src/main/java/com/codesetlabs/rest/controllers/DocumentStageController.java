package com.codesetlabs.rest.controllers;

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
public class DocumentStageController {

	@Autowired
	DocumentStageDao docStageDao;

	// CREATE
	@RequestMapping(value = "/docstage/create", method = RequestMethod.POST)

	public @ResponseBody ResponseEntity createCompany(@RequestBody DocumentStage docStage) {

		
		try {
			docStageDao.save(docStage);
		} catch (Exception e) {

			return new ResponseEntity<>(docStage, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(docStage, HttpStatus.OK);
	}

	// Update
	@RequestMapping(value = "/docstage/update/", method = RequestMethod.PATCH)

	public @ResponseBody ResponseEntity updateCompany(@RequestBody DocumentStage docStage) {

		System.out.println(docStage.getName());
		try {
			DocumentStage edited = docStageDao.findOne(docStage.getStageId());
			edited.setName(docStage.getName());
			docStageDao.save(edited);

		} catch (Exception e) {

			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(docStage, HttpStatus.OK);
	}

	// Delete
	@RequestMapping(value = "/docstage/delete/{id}", method = RequestMethod.DELETE)

	public @ResponseBody ResponseEntity deleteCompany(@PathVariable int id) {

		DocumentStage deleted = null;
		try {
			deleted = docStageDao.findOne(id);
			docStageDao.delete(id);

		} catch (Exception e) {

			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(deleted, HttpStatus.OK);
	}
	
	
	
	// Get
		@RequestMapping(value = "/docstage/{id}", method = RequestMethod.GET)

		public @ResponseBody DocumentStage getCompany(@PathVariable int id) {

			DocumentStage c = null;
			try {
				c = docStageDao.findOne(id);
				
				

			} catch (Exception e) {

				return null;
			}

			return c;
		}
}
