package in.ashokit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import in.ashokit.Demo;
import in.ashokit.Home;
import in.ashokit.util.AppSecurity;

@Configuration
public class AppConfig {

	public AppConfig() {
		System.out.println("AppConfig :: Constructor");
	}
	
	@Bean
	Demo demo1() {  //demo1
		System.out.println("bean method called.....1..");
		Demo d = new Demo("tejas","sinkar");
		// logic
		return d;//79823
	}
	
	@Bean
	Demo demo2() {  //demo2
		System.out.println("bean method called......2.");
		Demo de = new Demo("prajwal","sinkar");
		// logic
		return de; //7878
	}
	
	@Bean
	Home home1() {  //home1
		System.out.println("bean method called......3.");
		Home h = new Home();
		// logic
		return h;//79823
	}

}
