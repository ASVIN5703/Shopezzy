package com.dev.Shopezzy.DTO;

public class ProductDTO {

    private Long id;
    private String title;
    private String description;
    private int price;
    private String quantity;
    private String brand;
    private String sizes;
    private String imageUrl;
    private String category;

    public ProductDTO() {
        // Default constructor
    }

    public ProductDTO(Long id, String title, String description, int price, String quantity, String brand,
                      String sizes, String imageUrl, String category) {
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

    // Getters and Setters

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

    @Override
    public String toString() {
        return "ProductDTO [id=" + id + ", title=" + title + ", description=" + description + ", price=" + price
                + ", quantity=" + quantity + ", brand=" + brand + ", sizes=" + sizes + ", imageUrl=" + imageUrl
                + ", category=" + category + "]";
    }
}
