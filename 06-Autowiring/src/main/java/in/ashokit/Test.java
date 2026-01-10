package in.ashokit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {

		ApplicationContext ctxt = new ClassPathXmlApplicationContext("beans.xml");
		System.out.println(ctxt.getClass().getName()); 
		ATM atm = ctxt.getBean(ATM.class);

		atm.withdraw();

	}
}
