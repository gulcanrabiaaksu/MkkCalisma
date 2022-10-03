package com.project1.questapp.responses;

import java.io.Serializable;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;

import com.project1.questapp.entities.Post;

import lombok.Data;

@Data
@CrossOrigin(origins = "http://localhost:3000/")
public class PostResponse implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	 public Long id;
	 public Long userId;
	 public String userName;
	 public String title;
	 public String text;
	 public List<LikeResponse> postLikes;

	public PostResponse(Post entity, List<LikeResponse> likes) {
		this.id= entity.getId();
		this.userId= entity.getUser().getId();
		this.userName=entity.getUser().getUserName();
		this.title =entity.getTitle();
		this.text=entity.getText();
		this.postLikes= likes;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<LikeResponse> getPostLikes() {
		return postLikes;
	}

	public void setPostLikes(List<LikeResponse> postLikes) {
		this.postLikes = postLikes;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}

