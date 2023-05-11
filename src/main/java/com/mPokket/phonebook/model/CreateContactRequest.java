package com.mPokket.phonebook.model;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.springframework.validation.annotation.Validated;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateContactRequest  {
	
	@NotBlank(message = "firstName connot be null or empty")
	private String firstName;
	
	@NotBlank(message = "lastName connot be null or empty")
	private String lastName;
	
	@NotBlank(message = "phoneNumber connot be null or empty")
	@Pattern(regexp="(0/91)?[1-9][0-9]{9}", message="Invalid Phone Number!")
	private String phoneNumber;

}
