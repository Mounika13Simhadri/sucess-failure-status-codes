package com.springboot.statuscodes.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="status")
public class statusModel {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String category;
	
	
	public statusModel(Long id, String name, String category) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "httpStatus [Id=" + id + ", statusName=" + name + ", category=" + category + "]";
	}
	
}
