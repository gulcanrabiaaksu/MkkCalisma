package com.project1.questapp.responses;

import java.io.Serializable;
import java.util.List;
import com.project1.questapp.entities.Post;

import lombok.Data;

@Data
//@JsonAutoDetect(fieldVisibility = Visibility.ANY)
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
		this.userName=entity.getUser().getuserName();
		this.title =entity.getTitle();
		this.text=entity.getText();
		this.postLikes= likes;
		}
}

