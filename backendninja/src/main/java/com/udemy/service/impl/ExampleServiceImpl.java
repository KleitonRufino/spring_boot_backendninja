package com.udemy.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.udemy.entity.Person;
import com.udemy.service.ExampleService;
import com.udemy.util.QualifierUtil;

@Service(QualifierUtil.EXAMPLE_SERVICE_IMPL)
public class ExampleServiceImpl implements ExampleService {
	
	private static final Log LOG = LogFactory.getLog(ExampleServiceImpl.class);
	
	@Override
	public List<Person> getListPeople() {
		LOG.info("METHOD: 'getListPeople'");
		List<Person> people = new ArrayList<Person>();
		people.add(new Person("Joao", 23));
		people.add(new Person("Maria", 33));
		people.add(new Person("Pedro", 73));
		people.add(new Person("Thiago", 83));
		return people;
	}

}
