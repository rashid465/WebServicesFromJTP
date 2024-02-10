package com.WebServicesFromJTP.Bean;

public class HelloWorldBean {
	
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private Long id;	
	
	private String name;

	public HelloWorldBean(String string) {
		this.name = string;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


}
