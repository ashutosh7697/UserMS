package com.infosys.UserMS.dto;

public class ProductModel {
	
	private Long productId;
	private String brand;
	private String category;
	private String description;
	private String image;
	private Float price;
	private String productName;
	private Long rating;
	private Long sellerId;
	private Long stock;
	private String subCategory;
	
	public ProductModel() {
		super();
	}
	
	
	public ProductModel(Long productId, String brand, String category, String description, String image, Float price, String productName,
			Long rating, Long sellerId, Long stock, String subCategory) {
		super();
		this.productId = productId;
		this.brand = brand;
		this.category = category;
		this.description=description;
		this.image = image;
		this.price = price;
		this.productName = productName;
		this.rating = rating;
		this.sellerId = sellerId;
		this.stock = stock;
		this.subCategory=subCategory;
	}


	public Long getProductId() {
		return productId;
	}


	public void setProductId(Long productId) {
		this.productId = productId;
	}


	public String getBrand() {
		return brand;
	}


	public void setBrand(String brand) {
		this.brand = brand;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public Float getPrice() {
		return price;
	}


	public void setPrice(Float price) {
		this.price = price;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public Long getRating() {
		return rating;
	}


	public void setRating(Long rating) {
		this.rating = rating;
	}


	public Long getSellerId() {
		return sellerId;
	}


	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}


	public Long getStock() {
		return stock;
	}


	public void setStock(Long stock) {
		this.stock = stock;
	}
	
	
	public String getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}


	@Override
	public String toString() {
		return "ProductModel [productId=" + productId + ", brand=" + brand + ", category=" + category + ", description=" + description + ", image="
				+ image + ", price=" + price + ", productName=" + productName + ", rating=" + rating + ", sellerId="
				+ sellerId + ", stock=" + stock + ", subCategory="+subCategory +"]";
	}
	
}