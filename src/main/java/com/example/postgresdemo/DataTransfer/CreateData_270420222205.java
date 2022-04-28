package com.example.postgresdemo.DataTransfer;

public class CreateData_270420222205 extends Base {


	public CreateData_270420222205() {
		this.setDataName("CreateData_270420222205");
		this.setDescription("Criação de modelo teste");
	}
	
	@Override
	public void execute() {
		System.out.println("Hello Execute From " + this.getDataName() + " --- " + this.getDescription());
	}
	
}
