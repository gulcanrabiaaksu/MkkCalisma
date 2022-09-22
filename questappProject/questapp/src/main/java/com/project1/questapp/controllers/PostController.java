package com.project1.questapp.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.project1.questapp.requests.PostUpdateRequest;
import com.project1.questapp.responses.PostResponse;

@RestController
@RequestMapping("/posts")
@CrossOrigin(origins = "http://localhost:3000/")
public class PostController {

	@Autowired
	private PostService postService;
	@Autowired
	public PostController(PostService postService) {
		this.postService = postService;
	}
	
	@GetMapping //postlardan olusan liste dondurecek
	public List<PostResponse> getAllPosts(@RequestParam Optional<Long> userId) {
		return postService.getAllPosts(userId);
		/*List<PostResponse> list= postService.getAllPosts(userId);
		return list;*/
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
	public Post updateOnePost(@PathVariable Long postId, @RequestBody PostUpdateRequest updatePost) {
		return postService.updateOnePostById(postId, updatePost);
	}
	
	@DeleteMapping("/{postId}")
	public void deleteOnePost(@PathVariable Long postId) {
		postService.deleteOnePostById(postId);
	}
}