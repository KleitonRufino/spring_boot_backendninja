package com.udemy.service;

import java.util.List;

import com.udemy.entity.Course;


public interface CourseService {

	List<Course> listAllCourses();
	
	Course addCourse(Course course);

	int removeCourse(int id);

	Course updateCourse(Course course);
}
