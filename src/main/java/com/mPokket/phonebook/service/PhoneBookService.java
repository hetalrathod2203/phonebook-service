package com.mPokket.phonebook.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mPokket.phonebook.entity.Contact;
import com.mPokket.phonebook.model.CreateContactRequest;
import com.mPokket.phonebook.repository.ContactRepository;

@Service
public class PhoneBookService {
	
	private ContactRepository contactRepository;

	@Autowired
	public PhoneBookService(ContactRepository contactRepository) {
		super();
		this.contactRepository = contactRepository;
	}

	public List<Contact> create(CreateContactRequest req) {
		
		Contact contact = Contact.builder().firstName(req.getFirstName()).lastName(req.getLastName())
				.phoneNumber(req.getPhoneNumber()).createdAt(new Date()).build();
		contactRepository.save(contact);
		return Arrays.asList(contact);
	}
	
	public List<Contact> update(CreateContactRequest req) {
		
		Contact contact = contactRepository.findByFirstName(req.getFirstName());
		contact.setLastName(req.getLastName());
		contact.setPhoneNumber(req.getPhoneNumber());
		contact.setModifiedAt(new Date());
		contactRepository.save(contact);
		return Arrays.asList(contact);
	}
	
	public List<Contact> get() {
		
		List<Contact> contacts = new ArrayList<Contact>();
		for(Contact contact : contactRepository.findAll())
			contacts.add(contact);
		return contacts;
	}
	
	public void delete(String firstName) {
		
		Contact contact = contactRepository.findByFirstName(firstName);
		contactRepository.delete(contact);
	}
	
	
}
