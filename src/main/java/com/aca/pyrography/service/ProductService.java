package com.aca.pyrography.service;

import java.math.BigDecimal;
import java.util.List;

import com.aca.pyrography.dao.ProductDao;
import com.aca.pyrography.dao.ProductDaoImpl;
import com.aca.pyrography.dao.ProductDaoMock;
import com.aca.pyrography.model.Difficulty;
import com.aca.pyrography.model.Product;

public class ProductService {
	
	private ProductDao productDao = new ProductDaoImpl();
	
	public List<Product> getProducts() {
		return productDao.getProducts();
	}
	public List<Product> getProductsByDifficulty(Difficulty difficulty) {
		return productDao.getProductsByDifficulty(difficulty);
	}
	public List<Product> getProductsByName(String productName) {
		return productDao.getProductsByName(productName);
	}
	public List<Product> getProductsByPrice(BigDecimal productPrice) {
		return productDao.getProductsByPrice(productPrice);
	}
	public List<Product> getProductsByQuantity(Integer productQuantity) {
		return productDao.getProductsByQuantity(productQuantity);
	}
	public List<Product> getProductsByRating(Integer productRating) {
		return productDao.getProductsByRating(productRating);
	}
	public List<Product> getProductsById(Integer id) {
		return productDao.getProductsById(id);
	}
	public Product updateProduct(Product updateProduct) {
		return productDao.updateProduct(updateProduct);
	}
	public Product createProduct(Product newProduct) {
		return productDao.createProduct(newProduct);
	}
	public Product deleteProductById(Integer id) {
		return productDao.deleteProductById(id);
	}

}
