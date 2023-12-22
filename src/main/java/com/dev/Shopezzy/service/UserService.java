package com.dev.Shopezzy.service;

import com.dev.Shopezzy.DTO.LoginDTO;
import com.dev.Shopezzy.DTO.UserDTO;
import com.dev.Shopezzy.response.LoginMessage;


public interface UserService {
	String addUser(UserDTO userData);
	LoginMessage loginUser(LoginDTO loginData);
}
