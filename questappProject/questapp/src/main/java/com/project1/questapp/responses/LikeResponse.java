package com.project1.questapp.responses;


import java.io.Serializable;
//import com.fasterxml.jackson.annotation.JsonAutoDetect;
//import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.project1.questapp.entities.Like;

import lombok.Data;

@Data
//@JsonAutoDetect(fieldVisibility = Visibility.ANY)//ya da sınıf fieldlarının public olarak tanımlanması 
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
}
