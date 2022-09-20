package com.project1.questapp.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import com.project1.questapp.entities.Post;
import com.project1.questapp.entities.User;
import com.project1.questapp.repos.PostRepository;
import com.project1.questapp.requests.PostCreateRequest;
import com.project1.questapp.requests.PostUpdateRequest;
import com.project1.questapp.responses.PostResponse;

@Service
public class PostService {

	private PostRepository postRepository;
	private UserService userService;
	
	public PostService(PostRepository postRepository) {
		this.postRepository = postRepository;
		//this.userService=userService;
	}
/*
 * post response post controllerda donucez fakat bunun için 
 * post servicede bişeyler yapmamız lazım 
 * repostoryden tum  postları dondugumuzde o postun içinde gelen 
 * bilgiyi pars edip yeni bir post response yazmalıyız.
 * postların hepsini postresponse ile değiştiridik
 * post ve postresponce arasında maping yapmamız lazım
 * buynun içiden post recponce altında constracter oluştrumamız lazım içerisinde de post alıcak
 */
    
	public List<PostResponse> getAllPosts(Optional<Long> userId) {
		List<Post> list;
		if(userId.isPresent()) {
			 list = postRepository.findByUserId(userId.get());
		}else
			list = postRepository.findAll();
		return list.stream().map(p->new PostResponse(p)).collect(Collectors.toList());
		
	}

/*
 * eger bi user varsa userin değilse tum postları atıyoruz
 * post listesini databasede çekiyoruz
 * o listeyi postresponse listesine mapliyoruz. sonra o listeyi dönüyoruz
 */
	
	public Post getOnePostById(Long postId) {
		return postRepository.findById(postId).orElse(null);
	}

	public Post createOnePost(PostCreateRequest newPostRequest) {
		User user = userService.getOneUserById(newPostRequest.getUserId());
		if(user == null)
			return null;
		Post toSave = new Post();
		toSave.setId(newPostRequest.getId());
		toSave.setText(newPostRequest.getText());
		toSave.setTitle(newPostRequest.getTitle());
		toSave.setUser(user);
		return postRepository.save(toSave);
	}


	public Post updateOnePostById(Long postId, PostUpdateRequest updatePost) {
		Optional<Post> post = postRepository.findById(postId);
		if(post.isPresent()) {
			Post toUpdate = post.get();
			toUpdate.setText(updatePost.getText());
			toUpdate.setTitle(updatePost.getTitle());
			postRepository.save(toUpdate);
			return toUpdate;
		}
		return null;
	}

	public void deleteOnePostById(Long postId) {
		postRepository.deleteById(postId);
	}

}