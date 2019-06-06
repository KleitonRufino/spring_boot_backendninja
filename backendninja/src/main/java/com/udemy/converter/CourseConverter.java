package com.udemy.converter;

import org.springframework.stereotype.Component;

import com.udemy.entity.Course;
import com.udemy.model.CourseModel;

@Component
public class CourseConverter {

	// Entity --> Model
	public CourseModel entity2model(Course course) {
		CourseModel model = new CourseModel(course.getName(), course.getDescription(), course.getPrice(),
				course.getHours());
		return model;
	}

	// Model --> Entity
	public Course model2entity(CourseModel model) {
		Course course = new Course(model.getName(), model.getDescription(), model.getPrice(), model.getHours());
		return course;
	}

}
