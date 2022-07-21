package com.renansouza.workshopmongo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renansouza.workshopmongo.domain.Post;
import com.renansouza.workshopmongo.repository.PostRepository;
import com.renansouza.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired // Mecanismo de injeção automatica de dependencia do spring
	private PostRepository repo;
	
	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!"));
	}
	
}
