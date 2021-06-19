package com.hdsoft.JptAPI.Models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "pinconvert")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class PinConvert {

	@Id
	private int id;

	private String name;

	private String value;

	public PinConvert() {
		super();
	}

	public PinConvert(int id, String name, String value) {
		super();
		this.id = id;
		this.name = name;
		this.value = value;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
