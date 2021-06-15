package com.minishop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;


public class MiniShopDbUTil {
	private DataSource dataSource;

	public MiniShopDbUTil(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public List<Product> getProducts() throws Exception {
		List<Product> listProducts = new ArrayList<Product>();

		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		try {
			myConn = dataSource.getConnection();
			myStmt = myConn.createStatement();
			String sql = "select * from product";

			myRs = myStmt.executeQuery(sql);
			while (myRs.next()) {
				int productId = myRs.getInt("product_id");
				String productName = myRs.getString("product_name");
				int productPrice = myRs.getInt("product_price");
				String productDescription = myRs.getString("product_description");
				int categoryId = myRs.getInt("category_id");
				String productPicture = myRs.getString("product_picture");

				Product tempProduct = new Product(productId, productName, productPrice, productDescription, categoryId,
						productPicture);

				listProducts.add(tempProduct);
			}
			return listProducts;
		} finally {
			close(myConn, myStmt, myRs);
		}
	}

	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {

		try {
			if (myConn != null) {
				myConn.close();
			}
			if (myStmt != null) {
				myStmt.close();
			}
			if (myRs != null) {
				myRs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Category> getCategorys() throws Exception {
		List<Category> listCategorys = new ArrayList<Category>();

		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		try {
			myConn = dataSource.getConnection();
			myStmt = myConn.createStatement();
			String sql = "select * from category";

			myRs = myStmt.executeQuery(sql);
			while (myRs.next()) {
				int categoryId = myRs.getInt("category_Id");
				String categoryName = myRs.getString("category_name");

				Category tempCategory = new Category(categoryId, categoryName);
				listCategorys.add(tempCategory);
			}
			return listCategorys;
		} finally {
			close(myConn, myStmt, myRs);
		}
	}

	public List<Product> getProductsByCategory(String theCategoryId) throws Exception {
		List<Product> listProducts = new ArrayList<Product>();
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;

		try {
			myConn = dataSource.getConnection();
			String sql = "SELECT * FROM product where category_id=?";
			myStmt = myConn.prepareStatement(sql);

			myStmt.setString(1, theCategoryId);
			myRs = myStmt.executeQuery();
			System.out.println("hello");
			while (myRs.next()) {
				int productId = myRs.getInt("product_id");
				String productName = myRs.getString("product_name");
				int productPrice = myRs.getInt("product_price");
				String productDescription = myRs.getString("product_description");
				int categoryId = myRs.getInt("category_id");
				String productPicture = myRs.getString("product_picture");

				Product tempProduct = new Product(productId, productName, productPrice, productDescription, categoryId,
						productPicture);

				listProducts.add(tempProduct);
			}
			return listProducts;
		} finally {
			close(myConn, myStmt, myRs);
		}
	}

	public Product getProduct(String theProductId) throws Exception {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;

		Product theProduct = new Product();
		try {
			myConn = dataSource.getConnection();
			String sql = "SELECT * FROM product where product_id = ?";
			// create Statement
			myStmt = myConn.prepareStatement(sql);
			myStmt.setString(1, theProductId);

			myRs = myStmt.executeQuery();
			while (myRs.next()) {
				int productId = myRs.getInt("product_id");
				String productName = myRs.getString("product_name");
				int productPrice = myRs.getInt("product_price");
				String productDescription = myRs.getString("product_description");
				int categoryId = myRs.getInt("category_id");
				String productPicture = myRs.getString("product_picture");
				theProduct = new Product(productId, productName, productPrice, productDescription, categoryId,
						productPicture);
			}

			return theProduct;
		} finally {
			close(myConn, myStmt, myRs);
		}

	}

	public void addCategory(Category theCategory) throws Exception {
		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {
			myConn = dataSource.getConnection();
			String sql = "INSERT INTO category " + "(category_id, category_name )" + "VALUES (?,?)";
			myStmt = myConn.prepareStatement(sql);
			myStmt.setString(1, String.valueOf(theCategory.getCategoryId()));
			myStmt.setString(2, theCategory.getCategoryName());
			myStmt.execute();

		} finally {
			close(myConn, myStmt, null);
		}

	}

	public void deleleCategory(String theCategoryId) throws Exception {
		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {
			myConn = dataSource.getConnection();
			String sql = "Delete from category where category_id = ?";
			myStmt = myConn.prepareStatement(sql);
			myStmt.setString(1, theCategoryId);
			myStmt.execute();

		} finally {
			close(myConn, myStmt, null);
		}
		
	}

	public Category getCategoryById(String theCategoryId) throws Exception {
		Category category = new Category();
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;

		try {
			myConn = dataSource.getConnection();
			String sql = "SELECT * from category where category_id=?";
			myStmt = myConn.prepareStatement(sql);

			myStmt.setString(1, theCategoryId);
			myRs = myStmt.executeQuery();
			
			while (myRs.next()) {
				category.setCategoryId(myRs.getInt("category_id"));
				category.setCategoryName(myRs.getString("category_name"));
			}
			return category;
		} finally {
			close(myConn, myStmt, myRs);
		}
	}

	public void updateCategory(Category category) throws SQLException {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			myConn = dataSource.getConnection();
			String sql =  "UPDATE category SET category_name = ? WHERE category_id = ?";
			myStmt = myConn.prepareStatement(sql);
			myStmt.setString(1, category.getCategoryName());
			myStmt.setInt(2, category.getCategoryId());
			myStmt.execute();
			
			
		} finally {
			close(myConn, myStmt, null);
		}
	}
	

}
