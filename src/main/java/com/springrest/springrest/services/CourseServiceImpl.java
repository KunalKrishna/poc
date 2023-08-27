package com.springrest.springrest.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springrest.springrest.entities.Course;

@Service
public class CourseServiceImpl implements CourseService {
	
	List<Course> courseList;
	
	public CourseServiceImpl() {
		courseList = new ArrayList<>();
		courseList.add(new Course(123, "MBA", "A 2 year programme for Masters in Business Administration"));
		courseList.add(new Course(50, "CS", "Computer Science Bachelors course"));
		courseList.add(new Course(3412, "MSCS", "Masters in Science in Computer Sciences"));
	}
	
	@Override
	public List<Course> getCourses() {
		return courseList;
		// can be fetched from DB instead
	}

	@Override
	public Course getCourse(long courseID) {
		Course c = null;
		for(Course course : courseList) {
			if (course.getId() == courseID) {
				c = course;
				break;
			}
		}
		return c;
	}

	@Override
	public Course addCourse(Course course) {
		courseList.add(course);
		// can be persisted with db
		return course;
	}

	@Override
	public Course putCourse(Course course) {
		courseList.add(course);
		return course;
	}

	@Override
	public Course deleteCourse(long courseID) {
		Course c = null;
		for(Course course : courseList) {
			if (course.getId() == courseID) {
				c = course;
				courseList.remove(course);
				break;
			}
		}
		return c;
	}

}
