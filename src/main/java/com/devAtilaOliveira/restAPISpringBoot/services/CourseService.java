package com.devAtilaOliveira.restAPISpringBoot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devAtilaOliveira.restAPISpringBoot.entities.Course;
import com.devAtilaOliveira.restAPISpringBoot.repositories.CourseRepository;



@Service
public class CourseService {

		@Autowired
		private CourseRepository repository;
		
		public List<Course> fildAll() {
			return repository.findAll();
		}
		
		public Course insert(Course obj) {
			return repository.save(obj);
		}
}
