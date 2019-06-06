package com.udemy.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.udemy.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Serializable>{
	
	Course findByPrice(int price);
	Course findByPriceAndName(int price, String name);
	List<Course> findByNameOrderByHours(String name);
	Course findByNameOrPrice(String name, int price);
}
