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

@RestController
public class UserController {
	
	@Autowired
	UserService uService;

	@RequestMapping(value="create", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	@CrossOrigin(origins = "http://localhost:4200")
	@ResponseBody
	public int createUser(@RequestParam(name = "firstName") String firstName, @RequestParam(name = "lastName") String lastName) {
		
		int uId = uService.createUser(firstName, lastName);
		
		return uId;
	}
	
	@RequestMapping(value="getAllUsers", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@CrossOrigin(origins = "http://localhost:4200")
	@ResponseBody
	public List<User> getAllUsers(){
		return uService.getAllUsers();
	}
	
	@RequestMapping(value="getAUserById", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@CrossOrigin(origins = "http://localhost:4200")
	@ResponseBody
	public User getAUserById(@RequestParam(name = "id") String id) {
		return uService.getAUser(id);
	}
	
	@RequestMapping(value="updateProceso", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	@CrossOrigin(origins = "http://localhost:4200")
	@ResponseBody
	public void updateProceso(@RequestParam(name = "ids") List<String> ids) {
		uService.updateProceso(ids);
	}
	
	
}

