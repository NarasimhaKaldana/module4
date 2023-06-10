package com.example.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.resource.Product;
import com.example.services.ProductService;

@RestController
@RequestMapping("/product/api.2.0")
public class ProductResource {
	
	@Autowired
	ProductService service;
	
	@PostMapping
//	@ApiOperation(value= "postmapping")
	
	@RequestMapping(value="/create",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<?> addProduct(@RequestBody Product product ){
		
		
	
			
			
			Exception exception = null;
			Product tempProduct = null;
			
			try {
				tempProduct=
				 service.add(product);
				
			}catch(Exception e) {
			exception = e;
			}
			
			if(tempProduct != null) {
				return ResponseEntity.status(HttpStatus.CREATED).body(tempProduct);
			}
			else {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception);
				
			}
//			boolean result = service.add(product);
//			if(result) {
//				return ResponseEntity.status(HttpStatus.CREATED).body(true);
//			}else
//			{
//				return ResponseEntity.status(HttpStatus.CREATED).body(false);
//			}
			
		}
		
		
	}
  