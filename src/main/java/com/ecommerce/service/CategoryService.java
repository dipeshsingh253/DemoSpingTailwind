package com.ecommerce.service;

import java.util.List;

import com.ecommerce.exception.CategoryException;
import com.ecommerce.model.Category;

public interface CategoryService {
	
	
	public Category addCategory(Category category) throws CategoryException;
	
	public Category updateCategory(Category category) throws CategoryException;
	
	public List<Category> getAllCategories() throws CategoryException;

}
