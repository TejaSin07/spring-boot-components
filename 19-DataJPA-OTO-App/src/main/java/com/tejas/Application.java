package com.tejas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.tejas.service.PersonService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		PersonService bean = context.getBean(PersonService.class);
		bean.savePerson();
		bean.getPerson();
		bean.getPassport();  
		
	}

}
//get person --lazy-- 2 select query
// ---/------ ---eager--1 select query left join
// get passposrt --- lazy --- 1 left   select query 
// get passport  -----eager --- 1 left 