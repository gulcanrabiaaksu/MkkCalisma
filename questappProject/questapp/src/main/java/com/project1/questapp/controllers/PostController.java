package com.project1.questapp.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.project1.questapp.services.PostService;
import com.project1.questapp.entities.Post;
import com.project1.questapp.requests.PostCreateRequest;

@RestController
@RequestMapping("/posts")
public class PostController {

	private PostService postService;

	public PostController(PostService postService) {
		this.postService = postService;
	}
	
	@GetMapping //postlardan olusan liste dondurecek
	public List<Post> getAllPosts(@RequestParam Optional<Long> userId) {
		return postService.getAllPosts(userId);
	}

	
	@GetMapping("/{postId}")
	public Post getOnePost(@PathVariable Long postId) {
		return postService.getOnePostById(postId);
	}
	
	@PostMapping
	public Post createOnePost(@RequestBody PostCreateRequest newPost) {
		return postService.createOnePost(newPost);
	}

	@GetMapping("/{postId}")
	public Post getOnePost1(@PathVariable Long postId) {
		return postService.getOnePostById(postId);
	}
	
	@PutMapping("/{postId}")
	public Post updateOnePost(@PathVariable Long postId) {
		return postService.updateOnePostById(postId);
	}
	
	@DeleteMapping("/{postId}")
	public void deleteOnePost(@PathVariable Long postId) {
		postService.deleteOnePostById(postId);
	}
}