package com.project1.questapp.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project1.questapp.entities.RefreshToken;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long>{

	RefreshToken findByUserId(Long userId);
}