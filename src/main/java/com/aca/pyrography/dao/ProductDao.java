package com.aca.pyrography.dao;

import java.math.BigDecimal;
import java.util.List;

import com.aca.pyrography.model.Difficulty;
import com.aca.pyrography.model.Product;

public interface ProductDao {
	public List<Product> getProducts();
	public List<Product> getProductsByDifficulty(Difficulty difficulty);
	public List<Product> getProductsByName(String productName);
	public List<Product> getProductsByPrice(BigDecimal productPrice);
	public List<Product> getProductsByQuantity(Integer productQuantity);
	public List<Product> getProductsByRating(Integer productRating);
	public List<Product> getProductsById(Integer id);
	public Product updateProduct(Product updateProduct);
	public Product createProduct(Product newProduct);
	public Product deleteProductById(Integer id);
}
