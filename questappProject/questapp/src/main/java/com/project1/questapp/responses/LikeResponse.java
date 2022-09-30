package com.project1.questapp.responses;


import java.io.Serializable;

import org.springframework.web.bind.annotation.CrossOrigin;

//import com.fasterxml.jackson.annotation.JsonAutoDetect;
//import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.project1.questapp.entities.Like;

import lombok.Data;

@Data
@CrossOrigin(origins = "http://localhost:3000/")
public class LikeResponse  implements Serializable {
	
	private static final long serialVersionUID = 1L; 
	
	public Long id;
	public Long userId;
	public Long postId;

	public LikeResponse(Like entity) {
		this.id=entity.getId();
		this.userId=entity.getUser().getId();
		this.postId=entity.getPost().getId();

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

	public Long getPostId() {
		return postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
