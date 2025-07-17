package com.estoque.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estoque.model.Product;
import com.estoque.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	// Service ; 
	private ProductService productService ; 
	
	public ProductController(ProductService productService) {
		this.productService = productService; 
	}
	
	// Functions ; 
	
	@PostMapping
	public Product saveProduct(@RequestBody Product product) {
		return productService.saveProduct(product);
	}
	
	@GetMapping
	public List<Product> getProducts() {
		return productService.getProducts();
	}
	
	@DeleteMapping("/{id}")
	public void deleteProduct(@PathVariable("id") Long id) {
		productService.deleteProduct(id);
	}
	
	@PutMapping("/increment/{id}")
	public Product incrementProduct(@PathVariable("id") Long id, @RequestBody Integer quantity) {
		return productService.incrementProduct(id, quantity);
	}
	
	@PutMapping("/decrement/{id}")
	public Product decrementProduct(@PathVariable("id") Long id, @RequestBody Integer quantity) {
		return productService.decrementProduct(id, quantity);
	}
}
