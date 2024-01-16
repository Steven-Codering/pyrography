package com.aca.pyrography.controller;

import java.math.BigDecimal;
import java.util.List;


import com.aca.pyrography.model.Difficulty;
import com.aca.pyrography.model.Product;
import com.aca.pyrography.service.ProductService;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Produces(MediaType.APPLICATION_JSON)
@Path("/products")
public class ProductController {
	
	private ProductService service = new ProductService();
	
	@DELETE
	@Path("/{idValue}")
	public Product deleteProductById(@PathParam("idValue")Integer id) {
		return service.deleteProductById(id);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Product createProduct(Product newProduct) {
		return service.createProduct(newProduct);
	}
	
	@GET	
	public List<Product> getProducts() {
		return service.getProducts();
	}
	
	@GET
	@Path("/difficulty/{difficultyValue}")	
	public List<Product> getProductsByDifficulty(@PathParam("difficultyValue")Difficulty difficulty) {
		return service.getProductsByDifficulty(difficulty);
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Product updateProduct(Product updateProduct) {
		return service.updateProduct(updateProduct);
	}
	
	@GET
	@Path("/{idValue}")	
	public List<Product> getProductsById(@PathParam("idValue")Integer id) {
		return service.getProductsById(id);
	}
	
	@GET
	@Path("/name/{nameValue}")	
	public List<Product> getProductsByName(@PathParam("nameValue")String productName) {
		return service.getProductsByName(productName);
	}
	
	@GET
	@Path("/price/{priceValue}")	
	public List<Product> getProductsByPrice(@PathParam("priceValue")BigDecimal productPrice) {
		return service.getProductsByPrice(productPrice);
	}
	
	@GET
	@Path("/quantity/{quantityValue}")	
	public List<Product> getProductsByQuantity(@PathParam("quantityValue")Integer productQuantity) {
		return service.getProductsByQuantity(productQuantity);
	}
	
	@GET
	@Path("/rating/{ratingValue}")	
	public List<Product> getProductsByRating(@PathParam("ratingValue")Integer productRating) {
		return service.getProductsByRating(productRating);
	}
}
