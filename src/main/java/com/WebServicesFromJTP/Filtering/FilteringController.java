package com.WebServicesFromJTP.Filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.WebServicesFromJTP.Bean.SomeBean;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {
	
	//returning a single bean as response  
	@RequestMapping("/filtering")
	public SomeBean retrieveSomeBean() {
		 
		return new SomeBean("Amit", "9999999999", "39000");
	} 
	
	//returning a single bean as response  
	//values to send name and salary                                                              
	@RequestMapping("/filtering1")
	public MappingJacksonValue retrieveSomeBean1() {
		SomeBean someBean = new SomeBean("Amit", "9999999999", "39000");
		// invoking static method filterOutAllExcept()
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("name", "salary");
		// creating filter using FilterProvider class
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		MappingJacksonValue mapping = new MappingJacksonValue(someBean);
		mapping.setFilters(filters);
		return mapping; 
	} 
	 
	//returning a list of SomeBeans as response  
	@RequestMapping("/filtering-list")
	public List<SomeBean> retrieveListOfSomeBeans() {

		List<SomeBean> someBeans=Arrays.asList(new SomeBean("Rashid", "8888888888", "20000"),
				new SomeBean("Asif", "1111111111", "36000"),
				new SomeBean("Danish", "1111111111", "34000"));
		
		return someBeans;
	}
	
	
	@GetMapping("filtering-list1")
	public MappingJacksonValue retrieveListOfSomeBeans1() {
		List<SomeBean> list=Arrays.asList(new SomeBean("Saquib", "9575859612","30000"),
				new SomeBean("Hasnain", "9570857496", "49999"));
		
		SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept("name","phone");
		
		FilterProvider filterProvider= new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		
		MappingJacksonValue mapping=new MappingJacksonValue(list);
		mapping.setFilters(filterProvider);;
		return mapping;
	}
} 