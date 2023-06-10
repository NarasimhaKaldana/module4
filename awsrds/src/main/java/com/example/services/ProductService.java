 package com.example.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.repository.ProductRepository;
import com.example.resource.Product;

public class ProductService {
	
	
	@Autowired
	ProductRepository productRepository;
	
	
	public Product add(Product product) {
		
		Product productT= productRepository.save(product);
		
		return productT;
		
		
		
	}

	
	
}
