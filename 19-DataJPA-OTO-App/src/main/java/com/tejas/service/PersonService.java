package com.tejas.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tejas.entity.Passport;
import com.tejas.entity.Person;
import com.tejas.repo.PassportRepo;
import com.tejas.repo.PersonRepo;

@Service
public class PersonService {

	@Autowired
	private PersonRepo personRepo;

	@Autowired
	private PassportRepo passportRepo;
	
	public void getPassport() {
		Optional<Passport> byId = passportRepo.findById(1);
		System.out.println(byId.get());
	}

	public void getPerson() {
		Optional<Person> byId = personRepo.findById(1);
		System.out.println(byId.get());
	}

	public void savePerson() {

		Person p = new Person();
		p.setName("karan");
		p.setGender("Male");
		
		Passport pp = new Passport();
		pp.setPassportNum("JJ9");
		pp.setIssuedDate(LocalDate.now());
		pp.setExpDate(LocalDate.now().plusYears(10));

		// associating person with passport
		p.setPassport(pp);

		// associating passport with person
		pp.setPerson(p);

		// saving person record (parent)
		personRepo.save(p);// we are using cascade inside thats why along with saving person passport will also save

		System.out.println("Record inserted...");

	}

}
