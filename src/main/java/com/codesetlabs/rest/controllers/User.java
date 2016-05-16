package com.codesetlabs.rest.controllers;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;



@Entity
@Table(name="User")
public class User {
	  @Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  private int id;
	  	 	  
	  @NotNull
	  private String name;
	  
	  @NotNull
	  private String userName;
	  
	  @NotNull
	  private String authLevel;

	  // Public methods
	  
	  public User() { }

	  public User(int id) { 
	    this.id = id;
	  }
	  
	  
	  public int getId(){
		  return this.id;
	  }
	

	

}
