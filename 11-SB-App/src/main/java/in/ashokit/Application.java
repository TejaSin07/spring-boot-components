package in.ashokit;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.ashokit.service.PwdService;


@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		
		System.out.println(context.getBeanDefinitionCount() + "hi ");
		System.out.println(context.getClass().getName()); 

		PwdService service = context.getBean(PwdService.class);
		
		service.printfrmService();
		
	}

}
