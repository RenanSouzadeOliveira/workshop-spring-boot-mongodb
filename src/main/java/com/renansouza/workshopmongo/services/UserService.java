package com.renansouza.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renansouza.workshopmongo.domain.User;
import com.renansouza.workshopmongo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired // Mecanismo de injeção automatica de dependencia do spring
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
}
