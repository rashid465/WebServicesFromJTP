package com.WebServicesFromJTP.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.WebServicesFromJTP.Bean.Dummy;
import com.WebServicesFromJTP.Service.DummyService;

@RestController
@RequestMapping("/api")
public class DummyController {	
	
	@Autowired
	private DummyService dummyService;
	
	@PostMapping
	public ResponseEntity<String> createNewPersion(@RequestBody Dummy dummy) {
		
		Dummy newPersion =dummyService.savePersonDeatails(dummy);
		if (newPersion!=null) {
			String message="Successfully saved";
			return new ResponseEntity<String>(message,HttpStatus.OK);
		}
		else {
			String message="Something is wrong ";
			return new ResponseEntity<String>(message,HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@GetMapping
	public ResponseEntity<List<Dummy>> getAllPerson(){
		List<Dummy> allPerson=dummyService.getAllPerson();
		
		if (allPerson.size()>=1) {
			return new ResponseEntity<List<Dummy>>(allPerson,HttpStatus.OK);
		}
		else {
			String message="Person is available";
			return new ResponseEntity<List<Dummy>>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletePerson(@PathVariable Long id) {
		Dummy delete=dummyService.deletePerson(id);
		if (delete!=null) {
			String message="deleted successfully";
			return new ResponseEntity<String>(message,HttpStatus.OK);
		}
		else {
			String message="Person is not available with this id : "+id;
			return new ResponseEntity<String>(message,HttpStatus.NOT_FOUND);
		}
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> getPersonFromId(@RequestBody Dummy dummy, @PathVariable Long id){
		Dummy updatePeson=dummyService.updatePersonFromId(dummy,id);
		if (updatePeson!=null) {
			String message="Successfully Update Person";
			return new ResponseEntity<String>(message,HttpStatus.OK);
		}
		else {
			String message="Person is not availble with this id : "+id;
			return new ResponseEntity<String>(message,HttpStatus.OK);
		}
		
	}

}
