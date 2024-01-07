package com.dev.Shopezzy.service;

import java.util.List;

import com.dev.Shopezzy.DTO.ProductDTO;

public interface ProductService {
     List<ProductDTO>getAllProduct();
     boolean addProduct(ProductDTO products);
     ProductDTO getById(long id);
     boolean deleteproduct(long id);
     boolean updateProduct(ProductDTO product,long id );
}
