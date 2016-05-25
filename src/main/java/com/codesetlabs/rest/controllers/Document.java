package com.codesetlabs.rest.controllers;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="document")
public class Document {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int documentId;
	
	@ManyToOne
	@JoinColumn(name="id")
	private Product product;
	
	
	
	@Column
	private String name;
	
	@Column
	private String date;
	
	
	@ManyToOne
	@JoinColumn(name="idUser")
	private User user;
	
	
	@ManyToOne
	@JoinColumn(name="stageId")
	private DocumentStage documentStage;
	
	public int getDocumentId() {
		return documentId;
	}
	public void setDocumentId(int documentId) {
		this.documentId = documentId;
	}
	@JsonBackReference(value="product-reference")
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@JsonIgnore
	@JsonBackReference
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public DocumentStage getDocumentStage() {
		return documentStage;
	}
	public void setDocumentStage(DocumentStage documentStage) {
		this.documentStage = documentStage;
	}

}
