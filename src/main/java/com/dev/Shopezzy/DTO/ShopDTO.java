package com.dev.Shopezzy.DTO;

import java.util.List;

import com.dev.Shopezzy.model.ProductModel;


public class ShopDTO {
	
    long shopId;
	private String shop_name;
	private String img_url;
    private List<ProductModel> products;
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
		return "ShopDTO [shopId=" + shopId + ", shop_name=" + shop_name + ", img_url=" + img_url + ", products="
				+ products + "]";
	}
	public ShopDTO(long shopId, String shop_name, String img_url, List<ProductModel> products) {
		super();
		this.shopId = shopId;
		this.shop_name = shop_name;
		this.img_url = img_url;
		this.products = products;
	}
	public ShopDTO() {
		super();
	}
    
	

}
