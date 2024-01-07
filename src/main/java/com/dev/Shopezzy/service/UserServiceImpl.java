package com.dev.Shopezzy.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.Shopezzy.DTO.LoginDTO;
import com.dev.Shopezzy.DTO.UserDTO;
import com.dev.Shopezzy.model.UserModel;
import com.dev.Shopezzy.repository.UserRepository;
import com.dev.Shopezzy.response.LoginMessage;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
//	@Autowired
//	private PasswordEncoder passwordEncoder;
	
	@Override
	public String addUser(UserDTO userData) {
		UserModel newUser= new UserModel(userData.getId(),
				userData.getFirstName(),
				userData.getLastName(),
//				userData.getPassword(),
//				this.passwordEncoder.encode(userData.getPassword()),
				userData.getPassword(),
				userData.getEmail(),
				userData.getMobile() );
		
		userRepository.save(newUser);
		
	    System.out.println(newUser);
		return newUser.getFirstName();
	}

	@Override
	public LoginMessage loginUser(LoginDTO loginData) {
		String msg="";
		UserModel user=userRepository.findByEmail(loginData.getEmail());
		if(user!=null) {
			String password=loginData.getPassword();
			String encodePassword = user.getPassword();
//			passwordEncoder.matches(password,encodePassword);
			Boolean isPwtRight = password.equals(encodePassword);
			if(isPwtRight) {
				Optional<UserModel> user1=userRepository.findOneByEmailAndPassword(loginData.getEmail(), encodePassword);
				if(user1.isPresent())
				{
					return new LoginMessage("Login Successfully", true);
				}
				else
				{
					return new LoginMessage("Login Not Successfully", false);
				}
			}
			else {
				return new LoginMessage("Password Not Match", false);
			}
			
		}
		else
		{
			return new LoginMessage("Email Not Exist", false);
		}
		
	}

}
