package com.mPokket.phonebook.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mPokket.phonebook.entity.Contact;

@Repository
public interface ContactRepository extends CrudRepository<Contact, UUID> {
	
	Contact findByFirstName(String firstName);


}
