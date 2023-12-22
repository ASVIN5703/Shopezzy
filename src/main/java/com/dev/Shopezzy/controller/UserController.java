package com.dev.Shopezzy.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.Shopezzy.DTO.LoginDTO;
import com.dev.Shopezzy.DTO.UserDTO;
import com.dev.Shopezzy.response.LoginMessage;
import com.dev.Shopezzy.service.UserService;

@RestController
@CrossOrigin
//@RequestMapping("api/shopezzy/user")
@RequestMapping("/")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/save")
	public String saveUserfun(@RequestBody UserDTO userdata) {
		String name= userService.addUser(userdata);
		return "Data Saver Successfully ,UserNAme : "+ name;
	}
	
	@GetMapping("/")
//	public Map<String,Object> currentUser(OAuth2AuthenticationToken oAuth2AuthenticationToken)
//	{
//		return oAuth2AuthenticationToken.getPrincipal().getAttributes();
//	}
	public String demo() {
		return "get method called";
	}
	
	@GetMapping("/home")
	public String Home() {
		return "Welcome to home page";
	}
	
	@PostMapping("/login")
	public ResponseEntity<?>  loginUserfun(@RequestBody LoginDTO loginData){
		LoginMessage loginMessage = userService.loginUser(loginData);
		return ResponseEntity.ok(loginMessage);   
//		return "login Successfully";
	}

}
