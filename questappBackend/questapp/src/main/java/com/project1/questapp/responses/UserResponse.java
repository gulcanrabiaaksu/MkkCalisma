package com.project1.questapp.responses;

import org.springframework.web.bind.annotation.CrossOrigin;

import com.project1.questapp.entities.User;

import lombok.Data;

@Data
@CrossOrigin(origins = "http://localhost:3000/")
public class UserResponse {
	
	public Long id;
	public int avatarId;
	public String userName;

	public UserResponse(User entity) {
		this.id = entity.getId();
		this.avatarId = entity.getAvatar();
		this.userName = entity.getUserName();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getAvatarId() {
		return avatarId;
	}

	public void setAvatarId(int avatarId) {
		this.avatarId = avatarId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	} 
	
	
}