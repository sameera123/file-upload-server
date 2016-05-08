package com.codesetlabs.model;

public class FileDetails {
	
	private long id;
	private String fileName;
	private String createdDate;
	private long size;
	
	public FileDetails(long id,String fileName,String createdDate,long size){
		this.id = id;
		this.fileName = fileName;
		this.createdDate = createdDate;
		this.size = size;
	}
	
	public long getId(){
		return id;
	}
	
	public String getFileName(){
		return fileName;
	}
	
	public String getCreatedDate(){
		return createdDate;
	}
	
	public long getSize(){
		return size;
	}

}
