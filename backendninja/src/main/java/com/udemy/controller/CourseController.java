package com.udemy.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.entity.Course;
import com.udemy.service.CourseService;

@Controller
@RequestMapping("/courses")
public class CourseController {

	public static final String COURSES_VIEW = "courses";
	private static final Log LOG = LogFactory.getLog(CourseController.class);
	private static int count = 0;

	@Autowired
	private CourseService courseService;

	@GetMapping("/listcourses")
	public ModelAndView listAllCourses() {
		this.add();
		LOG.info("CALL: " + "listALLCourses()");
		ModelAndView mav = new ModelAndView(COURSES_VIEW);
		mav.addObject("course", new Course());
		mav.addObject("courses", courseService.listAllCourses());
		return mav;
	}

	@PostMapping("/addcourse")
	public String addCourse(@ModelAttribute("course") Course course) {
		LOG.info("Call: " + "addCourse() " + "-- Param: " + course);
		courseService.addCourse(course);
		return "redirect:/courses/listcourses";
	}

	private void add() {
		if (count == 0) {
			Course c1 = new Course("Spring Boot", "Spring Boot", 25, 40);
			Course c2 = new Course("Angular JS", "Spring Boot", 25, 40);
			Course c3 = new Course("JQuery", "Spring Boot", 25, 40);

			courseService.addCourse(c1);
			courseService.addCourse(c2);
			courseService.addCourse(c3);
		}
		count++;
	}

}
