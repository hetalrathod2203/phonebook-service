package com.mPokket.phonebook.entity;

import java.util.Date;
import java.util.UUID;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="contacts")
public class Contact {
	
    @Id
    @GeneratedValue()
    private UUID id;
    
    @Column(nullable = false, name = "first_name")
	private String firstName;
    
    @Column(nullable = false, name = "last_name")
	private String lastName;
    
    @Column(nullable = false, name = "phone_number")
	private String phoneNumber;
    
    @Column(name = "created_at", nullable = false)
	private Date createdAt;
    
    @Column(name = "modified_at")
	private Date modifiedAt ;

}
