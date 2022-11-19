package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.exception.CategoryException;
import com.ecommerce.model.Category;
import com.ecommerce.service.CategoryService;

@RestController
public class CategoryController {

	@Autowired
	CategoryService categoryService;

	@PostMapping("/categories")
	public ResponseEntity<Category> addCategory(@RequestBody Category Category) throws CategoryException {

		Category saved = categoryService.addCategory(Category);

		return new ResponseEntity<Category>(saved, HttpStatus.ACCEPTED);

	}

	@PutMapping("/categories")
	public ResponseEntity<Category> updateCategory(@RequestBody Category Category) throws CategoryException {

		Category updated = categoryService.updateCategory(Category);

		return new ResponseEntity<Category>(updated, HttpStatus.ACCEPTED);

	}

	@GetMapping("/categories")
	public ResponseEntity<List<Category>> getCategories() throws CategoryException {
		List<Category> Categorys = categoryService.getAllCategories();
		return new ResponseEntity<List<Category>>(Categorys, HttpStatus.OK);
	}

}
