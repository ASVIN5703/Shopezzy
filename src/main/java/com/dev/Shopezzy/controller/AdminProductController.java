package com.dev.Shopezzy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.Shopezzy.DTO.ProductDTO;
import com.dev.Shopezzy.service.ProductService;

@RestController
@RequestMapping("/v1/admin/products")


public class AdminProductController {
//	Logger logger = LoggerFactory.getLogger(AdminProductController.class);

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
	
	@PostMapping("/add")
	public ResponseEntity<String> addProducts(@RequestBody ProductDTO productDto) {
	    return productservice.addProduct(productDto) ?
	            ResponseEntity.ok("Product added successfully") :
	            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add product");
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateProduct(@RequestBody ProductDTO product ,@PathVariable long id){
		return productservice.updateProduct(product, id)?ResponseEntity.ok("Product id "+id+" uptaded successfully"):ResponseEntity.status(HttpStatus.CONFLICT).body("not updated or id invalid");
	}
    
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteProducts (@PathVariable long id){
		
	   return productservice.deleteproduct(id)?ResponseEntity.ok("Product id "+id+" deleted successfully"):ResponseEntity.status(HttpStatus.CONFLICT).body("not deleted or id invalid");
		
	}
}
