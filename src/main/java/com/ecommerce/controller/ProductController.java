package com.ecommerce.controller;

import java.util.List;

import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.exception.ProductException;
import com.ecommerce.model.Product;
import com.ecommerce.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping("/products")
	public ResponseEntity<Product> addProduct(@RequestBody Product product) throws ProductException {

		Product saved = productService.addProduct(product);

		return new ResponseEntity<Product>(saved, HttpStatus.ACCEPTED);

	}

	@PutMapping("/products")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product) throws ProductException {

		Product updated = productService.updateProduct(product);

		return new ResponseEntity<Product>(updated, HttpStatus.ACCEPTED);

	}

	@GetMapping("/products")
	public ResponseEntity<List<Product>> getProducts() throws ProductException {
		List<Product> products = productService.getAllProducts();
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}

}
