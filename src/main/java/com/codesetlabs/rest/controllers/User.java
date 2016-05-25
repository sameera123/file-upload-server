package com.codesetlabs.rest.controllers;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;



@Entity
@Table(name="user_new")
public class User {
	  @Id
	  @Column
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  private int idUser;
	  
	  
	  @OneToMany(mappedBy="user",cascade=CascadeType.ALL)
	  private Set<Document> documents;
	  	 	  
	  @NotNull
	  @Column
	  private String name;
	  
	  @NotNull
	  @Column
	  private String userName;
	  
	  @JsonManagedReference
	  public Set<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(Set<Document> documents) {
		this.documents = documents;
	}

	@NotNull
	  @Column
	  private String authLevel;
	  
	  public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAuthLevel() {
		return authLevel;
	}

	public void setAuthLevel(String authLevel) {
		this.authLevel = authLevel;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@JsonBackReference
	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@Column
	  private String password;
	  
	  @ManyToOne
	  @JoinColumn(name="idCompany")
	  private Company company;

	  // Public methods
	  


	

}
