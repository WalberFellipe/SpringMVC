package com.walber.mvc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.walber.mvc.models.UserDetails;
import com.walber.mvc.repository.Users;


@RestController
@RequestMapping(value="/api")
public class UserController {
	

	@Autowired
	Users userRepository;

	@GetMapping("/users")
	public List<UserDetails> returnAll(){
		return userRepository.findAll();
	}
	
	@GetMapping(path= "/users/{id}", produces= {MediaType.APPLICATION_JSON_VALUE})
	public UserDetails findId(@PathVariable(value="id")long id) {
		return userRepository.findById(id);
	}
	
	
	@PostMapping("/users")
	public UserDetails create(@Valid @RequestBody UserDetails user) {
		return userRepository.save(user);
	}

}
