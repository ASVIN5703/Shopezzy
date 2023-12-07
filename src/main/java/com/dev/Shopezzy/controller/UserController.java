package com.dev.Shopezzy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.Shopezzy.DTO.UserDTO;
import com.dev.Shopezzy.service.UserService;

@RestController
@CrossOrigin
//@RequestMapping("api/shopezzy/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/save")
	public String saveUser(@RequestBody UserDTO userdata) {
		String id= userService.addUser(userdata);
		return "Hi";
	}
	
	@GetMapping("/")
	public String vhjk() {
		return "HIIIIIIIIIIII";
	}
	

}
