package com.project1.questapp.responses;

import org.springframework.web.bind.annotation.CrossOrigin;

import com.project1.questapp.entities.Comment;

import lombok.Data;

@Data
@CrossOrigin(origins = "http://localhost:3000/")
public class CommentResponse {
	
	
	public Long id;
	public Long userId;
	public String userName;
	public String text;
	
	public CommentResponse(Comment entity) {
		this.id = entity.getId();
		this.userId = entity.getUser().getId();
		this.userName = entity.getUser().getUserName();
		this.text = entity.getText();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	

	
}