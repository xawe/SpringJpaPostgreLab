package com.example.postgresdemo.model.AutoData;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import com.example.postgresdemo.model.AuditModel;

@Entity
@Table(name = "data_entity")
public class DataEntity extends AuditModel {
	

	@Id
	@NotBlank
	@Column(columnDefinition = "text")
	private String dataName;

	@Column(columnDefinition = "text")
	private String description;
	
	@Column(columnDefinition = "int")
	private Integer status;

	public String getDataName() {
		return dataName;
	}

	public void setDataName(String dataName) {
		this.dataName = dataName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}
