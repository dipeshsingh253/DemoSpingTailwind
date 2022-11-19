package com.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.ecommerce.exception.ProductException;
import com.ecommerce.model.Product;
import com.ecommerce.repository.ProductRepository;

public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product addProduct(Product product) throws ProductException {

		Product existedProduct = productRepository.findByName(product.getName());

		if (existedProduct != null) {
			throw new ProductException("Product already exists");
		}

		return productRepository.save(product);
	}

	@Override
	public Product updateProduct(Product product) throws ProductException {

		Optional<Product> optional = productRepository.findById(product.getId());

		if (optional.isEmpty()) {
			throw new ProductException("Product does not exists");
		}

		return productRepository.save(product);
	}

	@Override
	public List<Product> getALlProducts() throws ProductException {

		List<Product> products = productRepository.findAll();

		if (products.size() == 0) {
			throw new ProductException("No Products Available");
		}
		return products;
	}

}
