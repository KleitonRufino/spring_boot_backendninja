package com.udemy.service;

import java.util.List;

import com.udemy.entity.Contact;
import com.udemy.model.ContactModel;

public interface ContactService {
	
	Contact addContact(ContactModel contactModel);
	
	List<ContactModel> listContacts();
	
	public Contact findContactById(int id);
	
	public ContactModel findContactModelById(int id);
	
	public void removeContact(int id);
}
