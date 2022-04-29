package com.example.postgresdemo.DataTransfer;

public abstract class Base {

	private String DataName;
	private String Description;
	
	public void execute() {
		
	}
	
	public void rollback() {
		
	}
	
	public String getDataName() {
		return DataName;
	}
	public void setDataName(String dataName) {
		DataName = dataName;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	
}
