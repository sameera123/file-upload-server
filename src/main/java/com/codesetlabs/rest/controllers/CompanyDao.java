package com.codesetlabs.rest.controllers;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

@Transactional
public interface CompanyDao extends CrudRepository<Company, Integer>{
	

}
