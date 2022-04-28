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
	
	@Column(columnDefinition = "boolean")
	private Boolean status;
}
