package com.dev.Shopezzy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.dev.Shopezzy.DTO.UserDTO;
import com.dev.Shopezzy.model.UserModel;
import com.dev.Shopezzy.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public String addUser(UserDTO userData) {
		
		UserModel newUser= new UserModel(userData.getId(),
				userData.getFirstName(),
				userData.getLastName(),
//				this.passwordEncoder.encode(userData.getPassword(),
				this.passwordEncoder.encode(userData.getPassword()),
				userData.getEmail(),
				userData.getMobile() );
		
		userRepository.save(newUser);
		
	    System.out.println(newUser);
		return newUser.getFirstName();
	}

}
