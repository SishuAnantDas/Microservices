package com.sis.expt.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sis.expt.dto.UserRequest;
import com.sis.expt.entity.User;
import com.sis.expt.exception.UserNotFoundException;
import com.sis.expt.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	public UserService userService;

	@PostMapping("/signup")
	public ResponseEntity<User> saveUser(@RequestBody @Valid UserRequest userRequest) {
		return new ResponseEntity<User>(userService.saveUser(userRequest), HttpStatus.CREATED);
	}
	
	@GetMapping("/fetchall")
	public ResponseEntity<List<User>> getAllusers(){
		return ResponseEntity.ok(userService.getAllusers());
		
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> getUser(@PathVariable int id) throws UserNotFoundException{
		return ResponseEntity.ok(userService.getUser(id));
	}
}
