package com.dev.Shopezzy.service;

import java.util.List;

import com.dev.Shopezzy.DTO.ShopDTO;
import com.dev.Shopezzy.model.ShopModel;

public interface ShopService {

	ShopDTO registerShop(ShopDTO shopModel);

	List<ShopDTO> viewAllShops();
 
}
