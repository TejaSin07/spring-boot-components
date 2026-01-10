package in.tejas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MsgController {

	@GetMapping("/greet")
	public String getGreet(Model model) {
		model.addAttribute("msg", "Good Morning...");
		return "index";
	}

	@GetMapping("/welcome")
	public String getWelcome(Model model) {
		int i = 10 / 0; //AE
		model.addAttribute("msg", "Welcome to CodeMicroSystem");
		return "index";
	}
	
	
//	  @ExceptionHandler(value = ArithmeticException.class)//if we want to handle  all exception we will write exception.class instead of Arithmatic public
//	  String handleAe(Exception e) { return "exView"; }
	 
	//above method used to handle exception in same class that is controller based handling	
}










