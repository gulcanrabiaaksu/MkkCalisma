package com.project1.questapp.entities;

 import java.util.Date;

//import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table(name="comment")
@Data
@CrossOrigin(origins = "http://localhost:3000/")
public class Comment {


	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	Long id;
	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="post_id", nullable=false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	Post post;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id", nullable=false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	User user;
	
	@Lob
    @Column(columnDefinition="text")
	String text;
	
	@Temporal(TemporalType.TIMESTAMP)
	Date createDate;

	
	public Date getCreateDate() {
		return createDate;
	}

	
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public String getText() {
		return text;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setText(String text) {
		this.text = text;
	}


}
