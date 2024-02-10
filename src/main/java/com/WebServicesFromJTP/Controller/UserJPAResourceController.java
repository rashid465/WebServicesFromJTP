package com.WebServicesFromJTP.Controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.WebServicesFromJTP.Bean.User;
import com.WebServicesFromJTP.Exception.UserNotFoundException;
import com.WebServicesFromJTP.Repository.UserRepository;
@RestController
@RequestMapping("jpa")
public class UserJPAResourceController {

	
	@Autowired
	private UserRepository userRepository;

	@GetMapping("/users")
	public List<User> retriveAllUsers() {
		System.out.println("find all ");
		List<User> user = userRepository.findAll();
		return user;
	}

	@GetMapping("/users/{id}")
	public ResponseEntity<User> retriveUser(@PathVariable Integer id) {
		User user = userRepository.findById(id).get();
		
		if (user == null) {
			throw new UserNotFoundException("id: " + id);
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	// method that delete a user resource
	@DeleteMapping("/users/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Integer id) {
		System.out.println("deleted ");
		Optional<User> user= userRepository.findById(id);
		if (user.isPresent()) {
			userRepository.deleteById(id);	
			String message="deleted successfully";
			return new ResponseEntity<String>(message, HttpStatus.OK);
		}
		else {
			String message="provided id : "+id+" is not persent";
			return new ResponseEntity<String>(message, HttpStatus.NOT_FOUND);
		}
		
	} 

	// method that posts a new user detail and returns the status of the user
	// resource
	@PostMapping("/save")
	public ResponseEntity<Object> createUser( @RequestBody User user) {
		System.out.println("inside save method");
		User sevedUser = userRepository.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(sevedUser.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PostMapping("/add")
	public ResponseEntity<String> createNewUser( @RequestBody User user) {
		System.out.println("inside save method");
		User sevedUser = userRepository.save(user);
		if (sevedUser!=null) {
			return new ResponseEntity<String>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}
}
