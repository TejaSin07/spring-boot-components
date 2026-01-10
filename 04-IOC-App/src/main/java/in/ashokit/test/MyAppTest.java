package in.ashokit.test;

import java.security.Provider.Service;


import org.springframework.context.ApplicationContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.ashokit.service.UserService;


public class MyAppTest {

	public static void main(String[] args) {

		ApplicationContext ctxt = new ClassPathXmlApplicationContext("beans.xml");
		UserService service = ctxt.getBean(UserService.class);
		System.out.println( service.getName(100));
	}

}
