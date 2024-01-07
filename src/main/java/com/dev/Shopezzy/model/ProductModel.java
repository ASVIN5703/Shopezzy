package com.dev.Shopezzy.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="products")
public class ProductModel {
   @Override
	public int hashCode() {
		return Objects.hash(brand, category, description, id, imageUrl, price, quantity, sizes, title);
	}
	public ProductModel() {
	super();
}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductModel other = (ProductModel) obj;
		return Objects.equals(brand, other.brand) && Objects.equals(category, other.category)
				&& Objects.equals(description, other.description) && Objects.equals(id, other.id)
				&& Objects.equals(imageUrl, other.imageUrl) && price == other.price
				&& Objects.equals(quantity, other.quantity) && Objects.equals(sizes, other.sizes)
				&& Objects.equals(title, other.title);
	}
public ProductModel(Long id, String title, String description, int price, String quantity, String brand,
			String sizes, String imageUrl, String category) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
		this.brand = brand;
		this.sizes = sizes;
		this.imageUrl = imageUrl;
		this.category = category;
	}
@Override
public String toString() {
	return "ProductModel [id=" + id + ", title=" + title + ", description=" + description + ", price=" + price
			+ ", quantity=" + quantity + ", brand=" + brand + ", sizes=" + sizes + ", imageUrl=" + imageUrl
			+ ", category=" + category + ", shop=" + shop + "]";
}
public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getSizes() {
		return sizes;
	}
	public void setSizes(String sizes) {
		this.sizes = sizes;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
@Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   private Long id;
   @Column(name="title")
   private String title;
   @Column(name="description")
   private String description;
   @Column(name="price")
   private int price;
   @Column(name="quantity")
   private String quantity;
   @Column(name="brand")
   private String brand;
   @Column(name="sizes")
   private String sizes;
   @Column(name="imageUrl")
   private String imageUrl;
   @Column(name="category")
   private String category;
   
   public ShopModel getShop() {
	return shop;
}
public void setShop(ShopModel shop) {
	this.shop = shop;
}
@ManyToOne
   @JoinColumn(name = "shop_id") 
   @JsonBackReference
   private ShopModel shop;
}
