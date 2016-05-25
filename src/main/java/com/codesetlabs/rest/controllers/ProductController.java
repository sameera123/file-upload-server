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
public class ProductController {
	
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	CompanyDao companyDao;
	// CREATE
		@RequestMapping(value = "/product/create", method = RequestMethod.POST)
		public @ResponseBody ResponseEntity createProduct(@RequestBody Product product) {

			try {
				Company company = companyDao.findOne(product.getCompany().getId());
				product.setCompany(company);
				productDao.save(product);

			} catch (Exception e) {

				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			}

			return new ResponseEntity<>(product, HttpStatus.OK);
		}
		
		
		
		// Get
		@RequestMapping(value = "/product/company/{id}", method = RequestMethod.GET)

		public @ResponseBody List<Product> getProductByCompany(@PathVariable int id) {

			List<Product> productList = null;
			try {
				Company c = companyDao.findOne(id);
				productList = productDao.findByCompany(c);
				

			} catch (Exception e) {

				return null;
			}

			return productList;
		}
		
		
		// Delete
		@RequestMapping(value = "/product/delete/{id}", method = RequestMethod.DELETE)

		public @ResponseBody ResponseEntity deleteCompany(@PathVariable int id) {

			Product deleted = null;
			try {
				deleted = productDao.findOne(id);
				companyDao.delete(id);

			} catch (Exception e) {

				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			}

			return new ResponseEntity<>(deleted, HttpStatus.OK);
		}
		
		
		
		// Get
				@RequestMapping(value = "/product/{id}", method = RequestMethod.GET)

				public @ResponseBody Product getProduct(@PathVariable int id) {

					Product c = null;
					try {
						c = productDao.findOne(id);
						
						

					} catch (Exception e) {

						return null;
					}

					return c;
				}


	
}
