package com.aca.pyrography.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.aca.pyrography.model.Difficulty;
import com.aca.pyrography.model.Product;

public class ProductDaoMock implements ProductDao{
	
	private static List<Product> products = new ArrayList<Product>();
	
	private static Integer lastProductId = 0;
	
	private static Integer getNextProductId() {
		return ++lastProductId;
	}
	
	static {
		Product cedar = new Product();
		cedar.setProductName("Cedar");
		cedar.setProductPrice(new BigDecimal("7.00"));
		cedar.setProductQuantity(6);
		cedar.setDifficulty(Difficulty.Beginner);
		cedar.setProductRating(5);
		
		Product birch = new Product();
		birch.setProductName("Birch");
		birch.setProductPrice(new BigDecimal("8.00"));
		birch.setProductQuantity(4);
		birch.setDifficulty(Difficulty.Intermediate);
		birch.setProductRating(3);
		
		Product whiteOak = new Product();
		whiteOak.setProductName("White Oak");
		whiteOak.setProductPrice(new BigDecimal("9.00"));
		whiteOak.setProductQuantity(2);
		whiteOak.setDifficulty(Difficulty.Expert);
		whiteOak.setProductRating(4);
		
		products.add(cedar);
		products.add(birch);
		products.add(whiteOak);
		
	}

	@Override
	public List<Product> getProducts() {
		List<Product> allProducts = new ArrayList<Product>();
		allProducts.addAll(products);
		return allProducts;
	}

	@Override
	public List<Product> getProductsByDifficulty(Difficulty difficulty) {
		List<Product> allProducts = new ArrayList<Product>();
		for(Product product : ProductDaoMock.products) {
			if(product.getDifficulty().equals(difficulty)) {
				allProducts.add(product);
			}
		}
		return allProducts;
	}

	@Override
	public List<Product> getProductsByName(String productName) {
		List<Product> allProducts = new ArrayList<Product>();
		for(Product product : ProductDaoMock.products) {
			if(product.getProductName().equals(productName.toString())) {
				allProducts.add(product);
			}
		}
		return allProducts;
	}

	@Override
	public List<Product> getProductsByPrice(BigDecimal productPrice) {
		List<Product> allProducts = new ArrayList<Product>();
		for(Product product : ProductDaoMock.products) {
			if(product.getProductPrice().equals(productPrice)) {
				allProducts.add(product);
			}
		}
		return allProducts;
	}

	@Override
	public List<Product> getProductsByQuantity(Integer productQuantity) {
		List<Product> allProducts = new ArrayList<Product>();
		for(Product product : ProductDaoMock.products) {
			if(product.getProductQuantity().equals(productQuantity)) {
				allProducts.add(product);
			}
		}
		return allProducts;
	}

	@Override
	public List<Product> getProductsByRating(Integer productRating) {
		List<Product> allProducts = new ArrayList<Product>();
		for(Product product : ProductDaoMock.products) {
			if(product.getProductQuantity().equals(productRating)) {
				allProducts.add(product);
			}
		}
		return allProducts;
	}

	@Override
	public List<Product> getProductsById(Integer id) {
		List<Product> allProducts = new ArrayList<Product>();
		for(Product product : ProductDaoMock.products) {
			if(product.getProductQuantity().equals(id)) {
				allProducts.add(product);
			}
		}
		return allProducts;
	}

	@Override
	public Product updateProduct(Product updateProduct) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product createProduct(Product newProduct) {
		newProduct.setId(getNextProductId());
		products.add(newProduct);
		return newProduct;
	}

	@Override
	public Product deleteProductById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
