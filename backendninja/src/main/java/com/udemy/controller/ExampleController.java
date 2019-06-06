package com.udemy.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.component.ExampleComponent;
import com.udemy.entity.Person;
import com.udemy.repository.PersonRepository;
import com.udemy.service.ExampleService;
import com.udemy.util.QualifierUtil;


@Controller
@RequestMapping("/example")
public class ExampleController {
	
	public static final String EXAMPLE_VIEW = "example"; 
	
	@Autowired
	@Qualifier("exampleComponent")
	private ExampleComponent exampleComponent;
	
	@Autowired
	@Qualifier(QualifierUtil.EXAMPLE_SERVICE_IMPL)
	private ExampleService exampleService;
	
	@Autowired
	private PersonRepository repository;
	
	@GetMapping(value = "/exampleString")
	public String exampleString(Model model){
		exampleComponent.sayHello();
		//model.addAttribute("person", new Person("Joao", 23));
		model.addAttribute("people", this.exampleService.getListPeople());
		List<Person> people = this.repository.findAll();
		System.out.println(people);
 		return EXAMPLE_VIEW;
	}
	
	@GetMapping(value = "/exampleMAV")
	public ModelAndView exampleMAV(){
		ModelAndView mav = new ModelAndView(EXAMPLE_VIEW);
		//mav.addObject("person", new Person("Maria", 33));
		mav.addObject("people", this.exampleService.getListPeople());
		return mav;
	}
}
