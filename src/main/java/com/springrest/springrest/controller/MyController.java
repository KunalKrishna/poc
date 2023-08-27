package com.springrest.springrest.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import com.springrest.springrest.entities.Course;
import com.springrest.springrest.services.CourseService;

@RestController
public class MyController {
	
	@Autowired
	CourseService courseService;
	
	@GetMapping("/home")
	public String home() {
		return "this is my home"; 
	}
	
	
	/**
	 * @return list of available courses
	 */
	@GetMapping("/courses") //@RequestMapping(path = "/courses", method = RequestMethod.GET) 
	public List<Course> getCourses() { 
		return courseService.getCourses();
	}
	
	/**
	 * @param courseID
	 * @return
	 */
	@GetMapping("/course/{courseID}")
	public Course getCourse(@PathVariable String courseID) { 
		// PathVariable name in fun() call shouldn't be anything but 'courseID'
		return courseService.getCourse(Long.parseLong(courseID));
	}
	
	/**
	 * @param course
	 * @return course
	 */
	@PostMapping("/courses")
	public Course addCourse(@RequestBody Course course) {
		return courseService.addCourse(course);
	}
	
	@PutMapping("/courses")
	public Course putCourse(@RequestBody Course course) {
		return courseService.putCourse(course);
	}
	
	@DeleteMapping("/course/{courseID}") 
	public Course deleteCourse(@PathVariable String courseID) {
		return courseService.deleteCourse(Long.parseLong(courseID));
	} 
}
