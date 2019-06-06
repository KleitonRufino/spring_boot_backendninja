package com.udemy.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udemy.entity.Course;
import com.udemy.repository.CourseRepository;
import com.udemy.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {

	private static final Log LOG = LogFactory.getLog(CourseServiceImpl.class);

	@Autowired
	private CourseRepository courseRepository;

	@Override
	public List<Course> listAllCourses() {
		LOG.info("Call: " + "listAllCourses()");
		return courseRepository.findAll();
	}

	@Override
	public Course addCourse(Course course) {
		LOG.info("Call: " + "addCourse " + "--PARAM: " + course);
		return courseRepository.save(course);
	}

	@Override
	public int removeCourse(int id) {
		LOG.info("Call: " + "addCourse " + "--PARAM: " + id);
		courseRepository.delete(id);
		return 0;
	}

	@Override
	public Course updateCourse(Course course) {
		LOG.info("Call: " + "addCourse " + "--PARAM: " + course);
		return courseRepository.save(course);
	}
}
