package com.dev.Shopezzy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.Shopezzy.DTO.ShopDTO;
import com.dev.Shopezzy.service.ShopService;

@RestController
@RequestMapping("/shop")
public class ShopController {
	
	 @Autowired
	    private ShopService shopService;

	    @PostMapping("/register")
	    public ShopDTO registerShop(@RequestBody ShopDTO shopData) {
	        return shopService.registerShop(shopData);
	    }
	    @GetMapping("/viewall")
	    public List<ShopDTO> viewAllShops() {
	        return shopService.viewAllShops();
	    }

	

}
