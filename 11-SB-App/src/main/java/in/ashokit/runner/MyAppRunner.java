package in.ashokit.runner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyAppRunner implements ApplicationRunner, CommandLineRunner {
    
	
	 @Override
	    public void run(String... args) throws Exception {
	        System.out.println("CommandLineRunner executed...");
	        for (String arg : args) {
	            System.out.println("Arg: " + arg);
	        }
	        // your logic
	    }
	 
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("ApplicationRunner executed...");
        System.out.println("Non-option args: " + args.getNonOptionArgs());
        System.out.println("Option names: " + args.getOptionNames());
        // your logic
    }

   
}
