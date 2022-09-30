package com.project1.questapp.responses;

import org.springframework.web.bind.annotation.CrossOrigin;

import lombok.Data;

@Data
@CrossOrigin(origins = "http://localhost:3000/")
public class AuthResponse {

	public String message;
	public Long userId;
	public String accessToken;
	public String refreshToken;
	
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public String getRefreshToken() {
		return refreshToken;
	}
	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}
	
	
	
}
	