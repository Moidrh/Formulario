package com.valid.formulario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.valid.formulario.entity.User;
import com.valid.formulario.service.UserService;

/**
 * Defines the controller for processing the HTTP requests to execute command
 * into User module
 * */
@RestController
public class UserController {
	
	/**
	 * Interface to communicate Web layer with the Service layer.
	 * */
	@Autowired
	UserService uService;

	/**
	 * Create a new User
	 * 
	 * @param firstName - The user first name
	 * @param lastName  - The user last name
	 * @return The new user id
	 * */
	@RequestMapping(value="create", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	@CrossOrigin(origins = "http://localhost:4200")
	@ResponseBody
	public int createUser(@RequestParam(name = "firstName") String firstName, @RequestParam(name = "lastName") String lastName) {
		
		int uId = uService.createUser(firstName, lastName);
		
		return uId;
	}
	
	/**
	 * Get all the users created
	 * 
	 * @return All the users that are created
	 * */
	@RequestMapping(value="getAllUsers", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@CrossOrigin(origins = "http://localhost:4200")
	@ResponseBody
	public List<User> getAllUsers(){
		return uService.getAllUsers();
	}
	
	/**
	 * Get a user by its id
	 * 
	 * @param id - The user id
	 * @return The user with the id
	 * */
	@RequestMapping(value="getAUserById", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@CrossOrigin(origins = "http://localhost:4200")
	@ResponseBody
	public User getAUserById(@RequestParam(name = "id") String id) {
		return uService.getAUser(id);
	}
	
	/**
	 * Process the user(s)
	 * 
	 * @param ids - The users ids
	 * */
	@RequestMapping(value="updateProceso", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	@CrossOrigin(origins = "http://localhost:4200")
	@ResponseBody
	public int updateProceso(@RequestParam(name = "ids") List<String> ids) {
		return uService.updateProceso(ids);
	}
	
	
}

