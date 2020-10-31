package com.example.springbootrestjpa.controller;

import com.example.springbootrestjpa.config.AppConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/")
public class IndexController {

    @Autowired
    AppConfig config;     

	@GetMapping("/")
	public String home(@RequestParam(value = "name", defaultValue = "Active") String name) {
		return String.format("Spring Boot rest jpa: %s!", name);		
    }
    
    @GetMapping("/name")
	public String name(@RequestParam(value = "name", defaultValue = "example") String name) {
		return String.format("Product name: %s", config.getProductName());
	}
	
}
