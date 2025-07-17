package com.estoque.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.estoque.exception.ProductException;
import com.estoque.model.Product;
import com.estoque.repository.ProductRepository;

@Service
public class ProductService {

	// Repository ; 

	private ProductRepository productRepository ; 
	
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	// Functions ;
	
	// POST ; 
	
	public Product saveProduct(Product product) {
		if(productRepository.findByName(product.getName()).isPresent()) { // Checking if there is already a product registered with the name entered ; 
			throw new ProductException("Error adding product! There is already a product registered with the name provided."); 
		}
		
		return productRepository.save(product);
	}
	
	// GET ; 
	
	public List<Product> getProducts() {
		return productRepository.findAll();
	}
	
	// DELETE ; 
	
	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}
	
	// PUT ; 
	
	public Product incrementProduct(Long id, Integer quantity) {
		if(quantity <= 0 ) { // Preventing the quantity from being an invalid value ; 
			throw new ProductException("Error when increasing product! The quantity entered must be greater than 0"); 
		}
		
		Optional<Product> product = productRepository.findById(id); // Searching for a product with the given ID ; 
		
		if(!product.isPresent()) { // If there is no product with the specified ID ;
			throw new ProductException("Error when increasing product! There is no product with the specified ID"); 
		}

		Product productIncrement = product.get(); // Turning Optional into a product
		productIncrement.setQuantity(productIncrement.getQuantity() + quantity); // Updating quantity ; 
		return productRepository.save(productIncrement);
		
	}
	
	public Product decrementProduct(Long id, Integer quantity) {
		if(quantity <= 0 ) { // Preventing the quantity from being an invalid value ; 
			throw new ProductException("Error when increasing product! The quantity entered must be greater than 0"); 
		}
	
		Optional<Product> product = productRepository.findById(id); // Searching for a product with the given ID ; 
		
		if(!product.isPresent()) { // If there is no product with the specified ID ;
			throw new ProductException("Error when increasing product! There is no product with the specified ID"); 
		}
		
		if(product.get().getQuantity() - quantity < 0) {
			throw new ProductException("Error decrementing product! Quantity cannot be negative"); 
		}
		
		product.get().setQuantity(product.get().getQuantity() - quantity);
		return productRepository.save(product.get());
	}
}
