package com.example.springbootrestjpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("/")
public class IndexController {

	@GetMapping("/")
	public String home(@RequestParam(value = "name", defaultValue = "Active") String name) {
		return String.format("Spring Boot rest jpa: %s!", name);		
	}
	
}
