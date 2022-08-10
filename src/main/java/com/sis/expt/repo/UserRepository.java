package com.sis.expt.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sis.expt.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByUserId(Integer id);

}
