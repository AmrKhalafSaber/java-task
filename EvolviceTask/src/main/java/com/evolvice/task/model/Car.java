package com.evolvice.task.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Car {
	@ApiModelProperty(required = false, hidden = true)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	@NotBlank
	private String brand;
	@NotBlank
	@Column
	private String model;
	
	@Column
	@Temporal(TemporalType.DATE)
	@ApiModelProperty(example="2018-11-14")
	private Date prodDate;
	
	@NotBlank
	private String modelDetails;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Date getProdDate() {
		return prodDate;
	}

	public void setProdDate(Date prodDate) {
		this.prodDate = prodDate;
	}

	public String getModelDetails() {
		return modelDetails;
	}

	public void setModelDetails(String modelDetails) {
		this.modelDetails = modelDetails;
	}

	public Car() {
	}

	public Car(String brand, String model, Date prodDate, String modelDetails) {
		super();
		this.brand = brand;
		this.model = model;
		this.prodDate = prodDate;
		this.modelDetails = modelDetails;
	}

}