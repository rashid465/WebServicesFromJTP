package com.WebServicesFromJTP.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.WebServicesFromJTP.Bean.User;
import com.WebServicesFromJTP.Exception.UserNotFoundException;
import com.WebServicesFromJTP.Service.UserDaoService;

@RestController
public class UserResourceController {
	
	@Autowired
	private UserDaoService userDaoService;
	
	// http://localhost:5000/users
	@GetMapping("users")
	public List<User> getAllUsers() {
		List<User> user=userDaoService.findAll();
		return user;
	}
	
	// http://localhost:5000/users/1
	@GetMapping("users/{id}")
	public User getFromId(@PathVariable Integer id) {
		User user=userDaoService.findOne(id);
		if (user!=null) {
			return user;
		}
		else {
			throw new UserNotFoundException("id : "+id);
		}
		
	}
	
	// http://localhost:5000/user
	@PostMapping("user")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User createUser=userDaoService.save(user);
		if (createUser!=null) {
			String message="successfully created new user.";
			return new ResponseEntity<Object>(message,HttpStatus.CREATED);
		}
		String message="somethings wrong.";
		return new ResponseEntity<Object>(message,HttpStatus.CREATED);
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<Object> deleteById(@PathVariable int id) {
		User deleteUser=userDaoService.deleteById(id);
		if (deleteUser!=null) {
			String message="Deleted successfully.";
			return new ResponseEntity<Object>(message,HttpStatus.OK);
		}
		String error="not found. Deletion failed..";
		return new ResponseEntity<Object>(error,HttpStatus.OK);
	}

}
