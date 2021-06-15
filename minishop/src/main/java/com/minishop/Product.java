package com.minishop;

public class Product {
	private int productId;
	private String productName;
	private int productPrice;
	private String productDescription;
	private int categoryId;
	private String productPicture;
	
	

	public Product(int productId, String productName, int productPrice, String productDescription, int categoryId,
			String productPicture) {
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productDescription = productDescription;
		this.categoryId = categoryId;
		this.productPicture = productPicture;
	}

	public Product(String productName, int productPrice, String productDescription, String productPicture) {
		super();
		this.productName = productName;
		this.productPrice = productPrice;
		this.productDescription = productDescription;
		this.productPicture = productPicture;
	}
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getProductPicture() {
		return productPicture;
	}

	public void setProductPicture(String productPicture) {
		this.productPicture = productPicture;
	}

	
	
	
}
