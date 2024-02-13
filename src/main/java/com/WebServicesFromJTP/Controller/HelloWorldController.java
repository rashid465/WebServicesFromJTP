package com.WebServicesFromJTP.Controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.WebServicesFromJTP.Bean.HelloWorldBean;

@Configuration
@RestController
public class HelloWorldController {
	
	// http://localhost:5000/helloWorld
	@GetMapping(path="/helloWorld")
	public String helloWorld() {
		return "Hello World";
	}
	
	// http://localhost:5000/helloWorld
	@GetMapping(path="/fun")
	public String fun() {
		return "Hello World";
	} 
	   
//	// http://localhost:5000/helloWorld
		@GetMapping(path="/check")
		public String check() {
			return "Hello World";
		}  
	 
	
	// http://localhost:5000/hello-world-bean
	@GetMapping(path="/hello-world-bean")  
	//method- which returns "Hello World"  
	public HelloWorldBean helloWorldBean()  
	{  
	return new HelloWorldBean("Hello World");//constructor of HelloWorldBean  
	}
	
	//passing a path variable  
	// http://localhost:5000/hello-world/path-variable/rashid
	@GetMapping(path="/hello-world/path-variable/{name}")  
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name)  
	{  
	return new HelloWorldBean(String.format("Hello World, %s",name)); //%s replace the name  
	}  

}
