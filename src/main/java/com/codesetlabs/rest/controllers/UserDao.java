package com.codesetlabs.rest.controllers;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

@Transactional
public interface UserDao extends CrudRepository<User, Integer>{
	public List<User> findByCompany(Company company);

}
