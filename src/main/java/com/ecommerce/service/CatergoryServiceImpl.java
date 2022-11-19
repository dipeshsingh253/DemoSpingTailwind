package com.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.exception.CategoryException;
import com.ecommerce.model.Category;
import com.ecommerce.repository.CategoryRepository;


@Service
public class CatergoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Category addCategory(Category category) throws CategoryException {

		Category existedCategory = categoryRepository.findByCategoryName(category.getCategoryName());

		if (existedCategory != null) {
			throw new CategoryException("Category alredy exists");
		}

		return categoryRepository.save(category);
	}

	@Override
	public Category updateCategory(Category category) throws CategoryException {

		Optional<Category> optional = categoryRepository.findById(category.getId());

		if (optional.isEmpty()) {
			throw new CategoryException("Category does not exists");
		}

		return categoryRepository.save(category);
	}

	@Override
	public List<Category> getAllCategories() throws CategoryException {

		List<Category> categories = categoryRepository.findAll();

		if (categories.size() == 0) {
			throw new CategoryException("No categories available");
		}

		return categories;
	}

}
