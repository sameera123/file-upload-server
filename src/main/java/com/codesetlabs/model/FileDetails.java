package com.codesetlabs.model;

public class FileDetails {
	
	private long id;
	private String fileName;
	private String createdDateTime;
	private long size;
	
	public FileDetails(long id,String fileName,String createdDateTime,long size){
		this.id = id;
		this.fileName = fileName;
		this.createdDateTime = createdDateTime;
		this.size = size;
	}
	
	public long getId(){
		return id;
	}
	
	public String getFileName(){
		return fileName;
	}
	
	public String getCreatedDate(){
		return createdDateTime;
	}
	
	public long getSize(){
		return size;
	}

}
