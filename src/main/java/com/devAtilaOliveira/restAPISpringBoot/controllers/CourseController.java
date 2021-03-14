package com.devAtilaOliveira.restAPISpringBoot.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.devAtilaOliveira.restAPISpringBoot.entities.Course;
import com.devAtilaOliveira.restAPISpringBoot.services.CourseService;

@RestController
@RequestMapping(value = "/courses")
public class CourseController {
	
	@Autowired
	private CourseService service;
	
	@GetMapping
	public ResponseEntity<List<Course>> findAll() {
		List<Course> list = service.fildAll();
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<Course> insert(@RequestBody Course obj) {
		obj = service.insert(obj);
		
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(obj.getId())
				.toUri();
		
		return ResponseEntity.created(uri).body(obj);
	}
}

