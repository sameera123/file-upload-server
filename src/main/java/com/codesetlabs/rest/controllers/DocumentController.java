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
public class DocumentController {

	@Autowired
	DocumentDao docDao;
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	UserDao userDao;

	// CREATE
	@RequestMapping(value = "/document/create", method = RequestMethod.POST)

	public @ResponseBody ResponseEntity createCompany(@RequestBody Document document) {

		
		try {
			
			Product product = productDao.findOne(document.getProduct().getId());
			User user = userDao.findOne(document.getUser().getIdUser());
			
			document.setProduct(product);
			document.setUser(user);
			
			docDao.save(document);
			
		} catch (Exception e) {

			return new ResponseEntity<>(document, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(document, HttpStatus.OK);
	}

//	// Update
//	@RequestMapping(value = "/docstage/update/", method = RequestMethod.PATCH)
//
//	public @ResponseBody ResponseEntity updateCompany(@RequestBody DocumentStage docStage) {
//
//		System.out.println(docStage.getName());
//		try {
//			DocumentStage edited = docStageDao.findOne(docStage.getStageId());
//			edited.setName(docStage.getName());
//			docStageDao.save(edited);
//
//		} catch (Exception e) {
//
//			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
//		}
//
//		return new ResponseEntity<>(docStage, HttpStatus.OK);
//	}
//
//	// Delete
//	@RequestMapping(value = "/docstage/delete/{id}", method = RequestMethod.DELETE)
//
//	public @ResponseBody ResponseEntity deleteCompany(@PathVariable int id) {
//
//		DocumentStage deleted = null;
//		try {
//			deleted = docStageDao.findOne(id);
//			docStageDao.delete(id);
//
//		} catch (Exception e) {
//
//			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
//		}
//
//		return new ResponseEntity<>(deleted, HttpStatus.OK);
//	}
//	
//	
//	
	// Get
		@RequestMapping(value = "/document/{id}", method = RequestMethod.GET)

		public @ResponseBody Document getCompany(@PathVariable int id) {

			Document c = null;
			try {
				c = docDao.findOne(id);
				
				

			} catch (Exception e) {

				return null;
			}

			return c;
		}
		
		
		// Get
				@RequestMapping(value = "/document/product/{id}", method = RequestMethod.GET)

				public @ResponseBody List<Document> getDocumentsByProduct(@PathVariable int id) {

					List<Document> c = null;
					try {
						
						Product product = productDao.findOne(id);
						c = docDao.findByProduct(product);
						
						

					} catch (Exception e) {

						return null;
					}

					return c;
				}
}
