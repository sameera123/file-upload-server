package com.codesetlabs.rest.controllers;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="Company_new")
public class Company {
	
	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	
	@JsonManagedReference
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	public void setId(int id) {
		this.id = id;
	}

	@NotNull
	@Column(name="name")
	private String name;
	
	
	@OneToMany(mappedBy="company",cascade=CascadeType.ALL)
	private Set<User> users;
	
	@OneToMany(mappedBy="company",cascade=CascadeType.ALL)
	private Set<Product> products;

	@JsonManagedReference
	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	public Company(String name){
		this.name = name;
	}
	public Company(){
		
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public int getId(){
		return id;
	}
}
