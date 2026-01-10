package in.tejas.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice   // global excep handler  (predife exception handler)
public class AppExceptionHandler {
	
	
	@ExceptionHandler(value = ProductNotFoundException.class) // method to handle user exception
	public String handleProductEx(ProductNotFoundException pne) {
		// logic 
		return "exView";
	}
	

//	@ExceptionHandler(value = Exception.class) //for predefine exception
//	public String handleAe(Exception e) {
//		// logic
//		return "exView";
//	}
}
