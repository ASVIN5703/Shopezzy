package com.dev.Shopezzy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.Shopezzy.DTO.ProductDTO;
import com.dev.Shopezzy.service.ProductService;

@RestController
@RequestMapping("/v1/user/products")
public class UserProductController {
	
	@Autowired
	private ProductService productservice;
	
	@GetMapping("/getAll")
	public ResponseEntity< List<ProductDTO>> getProducts(){
		 List<ProductDTO> productDTO = productservice.getAllProduct();
         System.out.print(productDTO+"sdfd");
         return ResponseEntity.status(productDTO.isEmpty() ? HttpStatus.NOT_FOUND : HttpStatus.OK)
                 .body(productDTO);
	}
	
	@GetMapping("get/{id}")
	public ResponseEntity<ProductDTO> getProductById(@PathVariable long id){
		ProductDTO product =productservice.getById(id);
		return ResponseEntity.status(product!=null ?HttpStatus.OK:HttpStatus.NOT_FOUND).body(product);
	}

}
