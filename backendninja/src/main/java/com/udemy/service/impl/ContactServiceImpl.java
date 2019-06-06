package com.udemy.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udemy.component.ContactConverter;
import com.udemy.entity.Contact;
import com.udemy.model.ContactModel;
import com.udemy.repository.ContactRepository;
import com.udemy.service.ContactService;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepository contactRepository;

	@Autowired
	private ContactConverter contactConverter;

	@Override
	public Contact addContact(ContactModel contactModel) {
		return contactRepository.save(contactConverter.convertContactModel2Contact(contactModel));
	}

	@Override
	public List<ContactModel> listContacts() {
		List<Contact> list = contactRepository.findAll();
		List<ContactModel> result = new ArrayList<ContactModel>();
		for (Contact contact : list) {
			result.add(contactConverter.convertContact2ContactModel(contact));
		}
		return result;
	}

	@Override
	public Contact findContactById(int id) {
		return contactRepository.findById(id);
	}

	@Override
	public ContactModel findContactModelById(int id) {
		return contactConverter.convertContact2ContactModel(findContactById(id));
	}
	
	@Override
	public void removeContact(int id) {
		Contact c = contactRepository.findById(id);
		Optional.ofNullable(c).ifPresent(o -> contactRepository.delete(o)); 
	}

}
