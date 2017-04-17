package iit.me.controller;

import org.springframework.http.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import iit.me.entity.UserEntity;
import iit.me.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@GetMapping(path="", produces=MediaType.APPLICATION_JSON_VALUE)
	Iterable<UserEntity> list(){
		return userService.listUsers();
	}
	
	@PostMapping(path="", consumes=MediaType.APPLICATION_JSON_VALUE)
	void createUser(@RequestBody UserEntity newUser) {
		userService.newUser(newUser);
	}
	
	@DeleteMapping(path="/{id}", consumes=MediaType.APPLICATION_JSON_VALUE)
	void deleteUser(@PathVariable("id")long id) {
		userService.deleteUser(id);
	}
	
	@PutMapping(path="/{id}", consumes=MediaType.APPLICATION_JSON_VALUE)
	void updateUser(@PathVariable("id")long id, @PathVariable String newFirstname, @PathVariable String newLastname) {
		userService.editUser(id, newFirstname, newLastname);
	}
	
	@GetMapping(path="/{id}", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	UserEntity findOne(@PathVariable long id) {
		return userService.findUser(id);
	}

}
