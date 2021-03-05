package com.valid.formulario.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valid.formulario.entity.User;
import com.valid.formulario.repository.UserRepository;

@Service
public class UserService{
	
	@Autowired
	UserRepository uRepo;
	
	
	public List<User> getAllUsers(){
		List<User> users = uRepo.findAll();
		
		return users;
	}
	
	
	public User getAUser(String id) {
		Optional<User> user = uRepo.findById(Integer.parseInt(id));
		
		if(user.isPresent()) {
			return user.get();
		}
		
		return null;
	}
	
	
	public int createUser( String firstName, String lastname) {
		
		User u = new User(firstName, lastname, false);
		
		User uAux = uRepo.save(u);
		
		int uId = uAux.getId();
		
		return uId;
	}
	
	public void updateProceso(List<String> ids) {
		
		for(int i = 0; i < ids.size(); i++) {
			Optional <User> u = uRepo.findById(Integer.parseInt(ids.get(i)));
			
			if(u.isPresent()) {
				User uAux = u.get();
				
				uAux.setProcesado(true);
				
				uRepo.save(uAux);
			}
		}
	}

}