package com.mPokket.phonebook.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mPokket.phonebook.model.CreateContactRequest;
import com.mPokket.phonebook.model.Response;
import com.mPokket.phonebook.service.PhoneBookService;
import com.mPokket.phonebook.util.Constants;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(path = "/phonebook")
@Slf4j
public class PhoneBookController {

	private PhoneBookService phoneBookService;
	
	@Autowired
	public PhoneBookController(PhoneBookService phoneBookService) {
		super();
		this.phoneBookService = phoneBookService;
	}

	@PostMapping(path = "/contact/create", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> createContact(@Valid @RequestBody CreateContactRequest req) {

		log.info(Constants.REQUEST_LOG, "Create");
		Response response = Response.builder().errorCode(HttpStatus.CREATED.value()).errorMessage("")
				.response(phoneBookService.create(req)).build();
		return new ResponseEntity<Response>(response, HttpStatus.CREATED);
	}
	
	@PutMapping(path = "/contact/update", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> updateContact(@Valid @RequestBody CreateContactRequest req) {

		log.info(Constants.REQUEST_LOG, "Update");		
		Response response = Response.builder().errorCode(HttpStatus.OK.value()).errorMessage("")
				.response(phoneBookService.update(req)).build();
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	
	@GetMapping(path = "/contact")
	public ResponseEntity<Response> getAllContacts() {

		log.info(Constants.REQUEST_LOG, "Get");
		Response response = Response.builder().errorCode(HttpStatus.OK.value()).errorMessage("")
				.response(phoneBookService.get()).build();
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	
	@DeleteMapping(path = "/contact/{firstName}")
	public ResponseEntity<Response> getContactBasedOnFirstName(@PathVariable String firstName) {

		log.info(Constants.REQUEST_LOG, "Delete");
		phoneBookService.delete(firstName);
		Response response = Response.builder().errorCode(HttpStatus.OK.value()).errorMessage("")
				.response(null).build();
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

}
