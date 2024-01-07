package com.dev.Shopezzy.service;



import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.dev.Shopezzy.DTO.ProductDTO;
import com.dev.Shopezzy.model.ProductModel;
import com.dev.Shopezzy.repository.ProductRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {
    
	
	private final ProductRepository productrepo;
    private final ModelMapper modelMapper;

    public ProductServiceImpl(ProductRepository productrepo, ModelMapper modelMapper) {
        this.productrepo = productrepo;
        this.modelMapper = modelMapper;
    }
    @Override
    public List<ProductDTO> getAllProduct() {
        List<ProductModel> productModels = productrepo.findAll();
        
        // Convert List<ProductModel> to List<ProductDTO>
        return productModels.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private ProductDTO convertToDto(ProductModel productModel) {
        return modelMapper.map(productModel, ProductDTO.class);
    }
	
    @Override
    public boolean addProduct(ProductDTO productDTO) {
        try {
            // Convert ProductDTO to ProductModel
            ProductModel productModel = convertToModel(productDTO);

            // Save the product to the repository
            productrepo.save(productModel);

            // Return true indicating successful addition
            return true;
        } catch (Exception e) {
            // Handle any exceptions and return false if the addition fails
            log.error("may be error in add product method of database operation"); // Log the exception or handle it according to your requirements
            return false;
        }
    }

   

    private ProductModel convertToModel(ProductDTO productDTO) {
        return modelMapper.map(productDTO, ProductModel.class);
    }
	@Override
	public boolean deleteproduct(long id) {
		
		 try {
		        // Check if the product with the given ID exists
		        if (productrepo.existsById(id)) {
		            // If it exists, delete the product
		            productrepo.deleteById(id);
		            return true;
		        } 
		    } catch (Exception e) {
		     
		        return false;
		    }
		return false;
	}
	@Override
	public boolean updateProduct(ProductDTO updatedProduct, long id) {
		Optional<ProductModel> optionalOldProduct = productrepo.findById(id);

        if (optionalOldProduct.isPresent()) {
            ProductModel oldProduct = optionalOldProduct.get();

            // Update fields excluding brand
            oldProduct.setTitle(updatedProduct.getTitle());
            oldProduct.setDescription(updatedProduct.getDescription());
            oldProduct.setPrice(updatedProduct.getPrice());
            oldProduct.setQuantity(updatedProduct.getQuantity());
            oldProduct.setSizes(updatedProduct.getSizes());
            oldProduct.setImageUrl(updatedProduct.getImageUrl());
            oldProduct.setCategory(updatedProduct.getCategory());
            oldProduct.setBrand(updatedProduct.getBrand());

            // Save the updated product
            productrepo.save(oldProduct);

            return true;
        } else {
            return false; 
        }
	}
	@Override
	public ProductDTO getById(long id) {
		Optional<ProductModel> optionalOldProduct = productrepo.findById(id);
		 if (optionalOldProduct.isPresent())
		 {
			 return optionalOldProduct.map(this::convertToDto).orElse(null);
		 }
		 else
		   return null;
	}
    
    

	

}
