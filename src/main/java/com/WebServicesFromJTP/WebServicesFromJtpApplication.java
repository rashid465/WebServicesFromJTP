package com.WebServicesFromJTP;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

     
        
@SpringBootApplication
//@EnableSwagger2
public class WebServicesFromJtpApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebServicesFromJtpApplication.class, args);
	}
	
//	public Docket apis() {
//		return new Docket (DocumentationType.SWAGGER_2).select()
//				.apis(RequestHandlerSelectors.basePackage("com.WebServicesFromJTP"))
//				.build();
//		}
 
}   
