package com.valid.formulario.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valid.formulario.entity.User;
import com.valid.formulario.repository.UserRepository;

/**
 * Concrete implementation to manage the application services of User
 * */
@Service
public class UserService{
	
	@Autowired
	UserRepository uRepo;
	
	
	public List<User> getAllUsers(){
		List<User> users = uRepo.findAll();
		
		return users;
	}
	
	/**
	 * Service that helps me to get all the users
	 * 
	 * @param id - The user id
	 * @return The user with the id
	 * */
	public User getAUser(String id) {
		Optional<User> user = uRepo.findById(Integer.parseInt(id));
		
		if(user.isPresent()) {
			return user.get();
		}
		
		return null;
	}
	
	/**
	 * Service that helps me to create a user
	 * 
	 * @param firstName - The user first name
	 * @param lastName  - The user last name
	 * @return The user id
	 * */
	public int createUser( String firstName, String lastname) {
		
		User u = new User(firstName, lastname, false);
		
		User uAux = uRepo.save(u);
		
		int uId = uAux.getId();
		
		return uId;
	}
	
	/**
	 * Service that helps me to process a user
	 * 
	 * @param ids - The user(s) id(s) to process
	 * @return If returns 1 the users have been update successfully, if returns the update has been failed
	 * */
	public int updateProceso(List<String> ids) {
		
		int success=1;
		
		for(int i = 0; i < ids.size(); i++) {
			Optional <User> u = uRepo.findById(Integer.parseInt(ids.get(i)));
			
			if(u.isPresent()) {
				User uAux = u.get();
				
				uAux.setProcesado(true);
				
				uRepo.save(uAux);
			} else {
				success = 0;
			}
		}
		
		if(success ==1) {
			return 1;
		} else {
			return 0;
		}
	}

}