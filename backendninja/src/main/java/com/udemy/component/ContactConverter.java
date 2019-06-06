package com.udemy.component;

import org.springframework.stereotype.Component;

import com.udemy.entity.Contact;
import com.udemy.model.ContactModel;

@Component
public class ContactConverter {

	public Contact convertContactModel2Contact(ContactModel model) {
		Contact contact = new Contact(model.getId(), model.getFirstname(), model.getLastname(), model.getTelephone(),
				model.getCity());
		return contact;
	}

	public ContactModel convertContact2ContactModel(Contact contact) {
		ContactModel model = new ContactModel(contact.getId(), contact.getFirstname(), contact.getLastname(),
				contact.getCity(), contact.getTelephone());
		return model;
	}

}
