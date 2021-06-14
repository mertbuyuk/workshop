package com.pia.workshop.service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.pia.workshop.dto.UserDTO;
import com.pia.workshop.model.User;
import com.pia.workshop.repository.UserRepository;


@Service
public class UserService {
	@Autowired UserRepository userRepository;
	
	public User addUser(UserDTO userDto) {
		
		User userExist= userRepository.findByUsername(userDto.getUserName());
		if(Objects.nonNull(userExist)) {
        	throw new RuntimeException("User exist"); 
		}
		
		User user= new User();
		user.setId(UUID.randomUUID());
		user.setName(userDto.getUserName());
		user.setSurname(userDto.getSurname());
		user.setUsername(userDto.getUserName());
		User newUser=userRepository.save(user);		
		return newUser;		
	}
	
	public List<User> findByName(String userName) {
		return userRepository.findByName(userName);
	}
	

}
