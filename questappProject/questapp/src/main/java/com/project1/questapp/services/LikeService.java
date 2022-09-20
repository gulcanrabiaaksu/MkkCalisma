package com.project1.questapp.services;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.project1.questapp.entities.Post;
import com.project1.questapp.entities.User;
import com.project1.questapp.entities.Like;
import com.project1.questapp.requests.LikeCreateRequest;
import com.project1.questapp.repos.LikeRepository;

import com.project1.questapp.services.LikeService;

@Service
public class LikeService {

	private LikeRepository LikeRepository;
	private UserService userService;
	private PostService postService;

	public LikeService(LikeRepository likeRepository) {
		this.LikeRepository = likeRepository;
		
	}

	public List <Like> getAllLikesWithParam(Optional<Long> userId, Optional<Long> postId) {
		if(userId.isPresent() && postId.isPresent()) {
			return LikeRepository.findByUserIdAndPostId(userId.get(), postId.get());
		}else if(userId.isPresent()) {
			return LikeRepository.findByUserId(userId.get());
		}else if(postId.isPresent()) {
			return LikeRepository.findByPostId(postId.get());
		}else
			return LikeRepository.findAll();
	}

	public Like getOneLikeById(Long likeId) {
		return LikeRepository.findById(likeId).orElse(null);
	}

	public Like createOneLike(LikeCreateRequest request) {
		User user = userService.getOneUserById(request.getUserId());
		Post post = postService.getOnePostById(request.getPostId());
		if(user != null && post != null) {
			Like likeToSave = new Like();
			likeToSave.setId(request.getId());
			likeToSave.setPost(post);
			likeToSave.setUser(user);
			return LikeRepository.save(likeToSave);
		}else		
			return null;
	}

	public void deleteOneLikeById(Long likeId) {
		LikeRepository.deleteById(likeId);
	}

}