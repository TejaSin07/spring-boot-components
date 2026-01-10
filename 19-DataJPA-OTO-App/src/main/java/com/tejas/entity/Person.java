package com.tejas.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "person_tbl")
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer personId;

	private String name;

	private String gender;  
	
//	@OneToOne(mappedBy = "person", cascade = CascadeType.ALL,fetch = FetchType.LAZY)	
//	private Passport passport;

	@OneToOne(mappedBy = "person",cascade = CascadeType.ALL)  //observe person is variable not a class
	private Passport passport;
	
	public Integer getPersonId() {
		return personId;
	}

	public void setPersonId(Integer personId) {
		this.personId = personId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Passport getPassport() {
		return passport;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
	}
	@Override
	public String toString() {
	    return "Person [personId=" + personId +
	           ", name=" + name +
	           ", gender=" + gender + 
	           "]";
	}


}
