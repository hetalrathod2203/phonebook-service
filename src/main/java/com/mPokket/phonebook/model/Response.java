package com.mPokket.phonebook.model;

import java.util.List;

import com.mPokket.phonebook.entity.Contact;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Response {

	private List<Contact> response;
	private int errorCode;
	private String errorMessage;
	
}
