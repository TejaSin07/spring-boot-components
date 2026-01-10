package in.ashokit.util;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import in.ashokit.Allinone;

@Component  //service // repository    id : emailUtils
public class EmailUtils implements Allinone{
	
	public EmailUtils() {
		System.out.println("EmailUtils::Constructor");
	}
	
	@Override
	public void printk() {
		// TODO Auto-generated method stub
		System.out.println("hello from emailUtils normal component class ");
	}
}
