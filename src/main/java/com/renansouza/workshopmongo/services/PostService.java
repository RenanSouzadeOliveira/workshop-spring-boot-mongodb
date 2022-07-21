package com.renansouza.workshopmongo.services;

import java.util.Date;
import java.util.List;
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
	
	public List<Post> findByTitle(String text){
		return repo.findByTitle(text);
	}
	
	public List<Post> fullSearch(String text, Date minDate, Date maxDate){
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 1000); // adicionando 24hrs na data para buscar durante todo o dia
		return repo.fullSearch(text, minDate, maxDate);
	}
}
