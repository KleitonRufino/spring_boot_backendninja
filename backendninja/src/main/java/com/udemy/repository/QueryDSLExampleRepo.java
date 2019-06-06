package com.udemy.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import com.udemy.entity.Course;
import com.udemy.entity.QCourse;

@Repository
public class QueryDSLExampleRepo {
	
	private QCourse qCourse = QCourse.course;
	
	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unused")
	public void find(boolean exists){
		JPAQuery<Course> query = new JPAQuery<Course>(em);
		
		BooleanBuilder predicateBuilder = new BooleanBuilder(qCourse.description.endsWith("OP"));
		if(exists){
			predicateBuilder.and(qCourse.id.eq(23));
		}else{
			predicateBuilder.or(qCourse.name.endsWith("OP"));
		}
		
		Course course1 = query.select(qCourse).from(qCourse).where(qCourse.id.eq(23)).fetchOne();
		Course course2 = (Course) query.select(qCourse.name, qCourse.description).from(qCourse).where(qCourse.id.eq(23)).fetchOne();
		Course course = query.select(qCourse).from(qCourse).where(predicateBuilder).fetchOne();
		
		List<Course> courses = query.select(qCourse).from(qCourse).where(qCourse.hours.between(20, 0)).fetch();
	}
}
