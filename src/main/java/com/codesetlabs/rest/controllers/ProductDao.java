package com.codesetlabs.rest.controllers;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

@Transactional
public interface ProductDao extends CrudRepository<Product, Integer> {
	
	public List<Product> findByCompany(Company company);

}
