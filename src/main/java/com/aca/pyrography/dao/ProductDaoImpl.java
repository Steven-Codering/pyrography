package com.aca.pyrography.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;

import com.aca.pyrography.model.Difficulty;
import com.aca.pyrography.model.Product;

public class ProductDaoImpl implements ProductDao{
	
	private static String insertProduct =
			"INSERT INTO supplies (productName, productRating, productPrice, productQuantity, experience) "
			+ "VALUES "
			+ " (?, ?, ?, ?, ?)";
	
	private static String updateProductById = 
			"UPDATE supplies "
			+ "SET productName = ?, "
			+ " productRating = ?, "
			+ " productPrice = ?, "
			+ " productQuantity = ?, "
			+	" experience = ? "
			+ "WHERE id = ?";
			
	
	private static String selectAllProducts = 
			"SELECT id, productName, productRating, productPrice, experience, productQuantity, updateDateTime, createDateTime "
			+ "FROM supplies";

	private static String selectAllProductsByDifficulty = 
			"SELECT id, productName, productPrice, experience, productQuantity, updateDateTime, createDateTime "
			+ "FROM supplies " +
			"WHERE experience = ?";
	
	private static String selectAllProductsByName = 
			"SELECT id, productName, productPrice, experience, productQuantity, updateDateTime, createDateTime "
			+ "FROM supplies " +
			"WHERE productname LIKE ? ";
	
	public static String selectProductsById =
			"SELECT id, productName, productRating, productPrice, productQuantity, experience, updateDateTime, createDateTime "
			+ "FROM supplies "
			+ "WHERE id = ?";
	
	private static String deleteProductById =
			"DELETE FROM supplies"
			+ " WHERE id = ?";
	
	@Override
	public List<Product> getProducts() {
		List<Product> allProducts = new ArrayList<Product>();
		ResultSet result = null;
		Statement statement = null;
		
		Connection conn = MariaDbUtil.getConnection();
		
		try {
			statement = conn.createStatement();
			result = statement.executeQuery(selectAllProducts);
			allProducts = makeProduct(result);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return allProducts;
	}

	private List<Product> makeProduct(ResultSet result) throws SQLException{
		List<Product> allProducts = new ArrayList<Product>();
		while(result.next()) {
			Product product = new Product();
			product.setId(result.getInt("id"));
			product.setProductName(result.getString("productName"));
			product.setProductRating(result.getInt("productRating"));
			product.setProductPrice(result.getBigDecimal("productPrice"));			
			product.setProductQuantity(result.getInt("productQuantity"));
			
			String difficultString = result.getString("experience");
			Difficulty difficult = Difficulty.convertStringToDifficulty(difficultString);
			product.setDifficulty(difficult);
			
			product.setUpdateDateTime(result.getObject("updateDateTime", LocalDateTime.class));
			product.setCreateDateTime(result.getObject("createDateTime", LocalDateTime.class));
			allProducts.add(product);
		}
		return allProducts;
	}

	@Override
	public List<Product> getProductsByDifficulty(Difficulty difficulty) {
		List<Product> allProducts = new ArrayList<Product>();
		ResultSet result = null;
		PreparedStatement statement = null;
		
		Connection connection = MariaDbUtil.getConnection();
		
		try {
			statement = connection.prepareStatement(selectAllProductsByDifficulty);
			statement.setString(1, difficulty.toString());
			
			result = statement.executeQuery();
			allProducts = makeProduct(result);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return allProducts;
	}

	@Override
	public List<Product> getProductsByName(String productName) {
		List<Product> allProducts = new ArrayList<Product>();
		ResultSet result = null;
		PreparedStatement statement = null;
		
		Connection connection = MariaDbUtil.getConnection();
		
		try {
			statement = connection.prepareStatement(selectAllProductsByName);
			statement.setString(1, "%" + productName + "%");
			
			result = statement.executeQuery();
			allProducts = makeProduct(result);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return allProducts;
	}

	@Override
	public List<Product> getProductsByPrice(BigDecimal productPrice) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getProductsByQuantity(Integer productQuantity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getProductsByRating(Integer productRating) {
		List<Product> allProducts = new ArrayList<Product>();
		ResultSet result = null;
		PreparedStatement statement = null;
		
		Connection connection = MariaDbUtil.getConnection();
		
		try {
			statement = connection.prepareStatement(selectProductsById);
			statement.setInt(1, productRating);
			
			result = statement.executeQuery();
			allProducts = makeProduct(result);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return allProducts;
	}

	@Override
	public List<Product> getProductsById(Integer id) {
		List<Product> allProducts = new ArrayList<Product>();
		ResultSet result = null;
		PreparedStatement statement = null;
		
		Connection connection = MariaDbUtil.getConnection();
		
		try {
			statement = connection.prepareStatement(selectProductsById);
			statement.setInt(1, id);
			
			result = statement.executeQuery();
			allProducts = makeProduct(result);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return allProducts;
	}

	@Override
	public Product updateProduct(Product updateProduct) {
		PreparedStatement ps = null;
		
		Connection connection = MariaDbUtil.getConnection();
		try {
			ps = connection.prepareStatement(updateProductById);
			
			ps.setString(1, updateProduct.getProductName());
			ps.setInt(2, updateProduct.getProductRating());
			ps.setBigDecimal(3, updateProduct.getProductPrice());
			ps.setInt(4, updateProduct.getProductQuantity());
			ps.setString(5, updateProduct.getDifficulty().toString());
			ps.setInt(6, updateProduct.getId());
			int rowCount = ps.executeUpdate();
			System.out.println("rows updated: " + rowCount);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return updateProduct;
	}

	@Override
	public Product createProduct(Product newProduct) {
		PreparedStatement ps = null;
		
		Connection connection = MariaDbUtil.getConnection();
		try {
			ps = connection.prepareStatement(insertProduct);
			ps.setString(1, newProduct.getProductName());
			ps.setInt(2, newProduct.getProductRating());
			ps.setBigDecimal(3, newProduct.getProductPrice());
			ps.setInt(4, newProduct.getProductQuantity());
			ps.setString(5, newProduct.getDifficulty().toString());
			int rowCount = ps.executeUpdate();
			System.out.println("rows inserted: " + rowCount);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return newProduct;
	}

	@Override
	public Product deleteProductById(Integer id) {
		List<Product> products = getProductsById(id);
		Product productToDelete = null;
		
		if(products.size() > 0) {
			productToDelete = products.get(0);
			int updateRowCount = 0;
			PreparedStatement ps = null;
			
			Connection connection = MariaDbUtil.getConnection();
			try {
				ps = connection.prepareStatement(deleteProductById);
				ps.setInt(1, id);
				updateRowCount = ps.executeUpdate();
				System.out.println("rows deleted: " + updateRowCount);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return productToDelete;
	}
	
	

}
