package com.udemy.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.udemy.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Serializable>{
	
	Contact findById(int id);
}
