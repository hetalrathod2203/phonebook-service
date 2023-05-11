package com.mPokket.phonebook.exception;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException.NotFound;

import com.mPokket.phonebook.model.Response;
import com.mPokket.phonebook.util.Constants;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class PhoneBookServiceExceptions {
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<Response> handleTooManyRequestException(NoSuchElementException ex){
		
		log.error(Constants.EXCEPTION_LOG, ex);
		Response response = Response.builder().errorCode(HttpStatus.NOT_FOUND.value()).errorMessage(HttpStatus.NOT_FOUND.getReasonPhrase()).build();
		return new ResponseEntity<Response>(response, HttpStatus.NOT_FOUND);		
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Response> handleException(Exception ex){
		
		log.error(Constants.EXCEPTION_LOG, ex);
		Response response = Response.builder().errorCode(HttpStatus.INTERNAL_SERVER_ERROR.value()).errorMessage(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase()).build();
		return new ResponseEntity<Response>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}

}
