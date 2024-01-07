package com.dev.Shopezzy.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="shopmodel")
public class ShopModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	long shopId;
	
	public long getShopId() {
		return shopId;
	}

	public void setShopId(long shopId) {
		this.shopId = shopId;
	}

	public String getShop_name() {
		return shop_name;
	}

	public void setShop_name(String shop_name) {
		this.shop_name = shop_name;
	}

	public String getImg_url() {
		return img_url;
	}

	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}

	public List<ProductModel> getProducts() {
		return products;
	}

	public void setProducts(List<ProductModel> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "ShopModel [shopId=" + shopId + ", shop_name=" + shop_name + ", img_url=" + img_url + ", products="
				+ products + "]";
	}

	@Column(name="shop_name")
	private String shop_name;
	
	@Column(name="img_url")
	private String img_url;
	
	  @OneToMany(mappedBy = "shop", cascade = CascadeType.ALL) 
	  @JsonManagedReference
	  private List<ProductModel> products;
	
	
	

}
