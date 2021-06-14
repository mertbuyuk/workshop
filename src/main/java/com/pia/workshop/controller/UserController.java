package com.pia.workshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pia.workshop.dto.UserDTO;
import com.pia.workshop.model.User;
import com.pia.workshop.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/add-user")
	public User addBasketItem(@RequestBody UserDTO userDTO) {
		return userService.addUser(userDTO);
	}

	@GetMapping("user-name/{name}")
	public List<User> getUserByName(@PathVariable("name") String name) {
		return userService.findByName(name);
	}
}
