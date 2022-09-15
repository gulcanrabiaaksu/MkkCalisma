package com.project1.questapp.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project1.questapp.entities.User;
public interface UserRepository extends JpaRepository<User, Long> {
	

	User findByUserName(String userName);

}
