package com.project1.questapp.responses;


import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.project1.questapp.entities.Post;

import lombok.Data;

@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class PostResponse implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	 Long id;
	 Long userId;
	 String userName;
	 String title;
	 String text;

	public PostResponse(Post entity) {
		this.id= entity.getId();
		this.userId= entity.getUser().getId();
		this.userName=entity.getUser().getuserName();
		this.title =entity.getTitle();
		this.text=entity.getText();
		}
}
