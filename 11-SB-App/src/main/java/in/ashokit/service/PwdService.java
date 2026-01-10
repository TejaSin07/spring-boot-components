package in.ashokit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import in.ashokit.Allinone;
import in.ashokit.Demo;

@Component
public class PwdService {
	
	@Autowired
	@Qualifier("home1")
	Allinone d;
	
	public PwdService() {
		System.out.println("PwdService::Constructor");
	}
	
	
	public void printfrmService() {
		d.printk();
	}
	
	

}
