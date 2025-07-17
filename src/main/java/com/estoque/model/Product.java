package com.estoque.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

@Entity
@Table(name = "products")
public class Product {

	// Attributes ; 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ; 
	private String name ; 
	private String description ; 
	private Integer quantity = 0 ; 
	
	// Builders ; 
	
	public Product() {
		
	}
	
	public Product(String name, String description) {
		this.name = name ; 
		this.description = description ; 
		this.quantity = 0 ; 
	}

	// Getters and Setters ; 

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getQuantity() {
		return quantity;
	}
	
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	// ToString ; 
	
	@Override
	public String toString() {
		return "Product [Id=" + id + ", name=" + name + ", description=" + description + ", quantity=" + quantity + "]";
	}
}
