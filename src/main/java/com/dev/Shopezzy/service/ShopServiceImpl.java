package com.dev.Shopezzy.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.dev.Shopezzy.DTO.ShopDTO;
import com.dev.Shopezzy.model.ProductModel;
import com.dev.Shopezzy.model.ShopModel;
import com.dev.Shopezzy.repository.ProductRepository;
import com.dev.Shopezzy.repository.ShopRepository;

@Service
public class ShopServiceImpl implements ShopService {
	
	
	private final ShopRepository shopRepo;
	 private final ModelMapper modelMapper;
	 private final ProductRepository productRepository;

	
	public ShopServiceImpl(ShopRepository shopRepo,ProductRepository productRepo, ModelMapper modelMapper) {
		super();
		this.shopRepo = shopRepo;
		this.modelMapper = modelMapper;
		 this.productRepository = productRepo;
	}
	@Override
	public ShopDTO registerShop(ShopDTO shopModel) {
		List<ProductModel> products = shopModel.getProducts();

	    ShopModel shop = convertToModel(shopModel);
	    shop.setProducts(products);

	    // Save the shop to get the shop ID
	    ShopModel savedShop = shopRepo.save(shop);

	    // Set the shop ID for each associated product
	    for (ProductModel p : products) {
	        p.setShop(savedShop);
	    }

	    // Save the products with the updated association to the shop
	    productRepository.saveAll(products);

	    return shopModel;	
		}
	private ShopDTO convertToDto(ShopModel shopModel) {
	        return modelMapper.map(shopModel, ShopDTO.class);
	    }
	
	 private ShopModel convertToModel(ShopDTO shopDTO) {
	        return modelMapper.map(shopDTO, ShopModel.class);
	    }
	@Override
	public List<ShopDTO> viewAllShops() {
		  List<ShopModel> shopdata= shopRepo.findAll();
		   
		   return shopdata.stream()
	                .map(this::convertToDto)
	                .collect(Collectors.toList());
	}


}
