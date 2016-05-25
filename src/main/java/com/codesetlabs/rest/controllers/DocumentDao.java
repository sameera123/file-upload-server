package com.codesetlabs.rest.controllers;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface DocumentDao extends CrudRepository<Document, Integer> {
	
	
	public List<Document> findByProduct(Product product);
	public List<Document> findByUser(User user);
	

}
