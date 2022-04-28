package com.example.postgresdemo.model.AutoData;

public enum DataEntityStatusEnum {
	PENDENTE(1),
	EXECUTADO(2),
	ERRO(3);
	
	private final Integer status;
	
	private DataEntityStatusEnum(Integer status) {
        this.status = status;
    }
	
	public int getStatus() {
        return this.status;
    }
	
}
