package com.sis.expt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sis.expt.dto.UserRequest;
import com.sis.expt.entity.User;
import com.sis.expt.exception.UserNotFoundException;
import com.sis.expt.repo.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public User saveUser(UserRequest userRequest) {

		User user = new User();

		user.setName(userRequest.getName());
		user.setEmail(userRequest.getEmail());
		user.setGender(userRequest.getGender());
		user.setMobile(userRequest.getMobile());
		user.setNationality(userRequest.getNationality());
		user.setAge(userRequest.getAge());

		return repository.save(user);
	}

	public List<User> getAllusers() {
		return repository.findAll();
	}

	public User getUser(Integer id) throws UserNotFoundException {
		User user = repository.findByUserId(id);
		if (user != null) {
			return user;
		} else {
			throw new UserNotFoundException("User not found with id :" + id);
		}

	}
}
