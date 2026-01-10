package in.tejas.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
//this class nothing to do with customer Controller
@RestController
public class DemoRestController {

	@GetMapping(value = "/msg", produces = "text/plain")  //if we change text to json here ,then also we got text as we are not 
														//  returning any object ,we are returning only text here
	public ResponseEntity<String> getMsg() {
		String msg = "Welcome to Ashok IT";
		return new ResponseEntity<>(msg, HttpStatus.OK);
	}

	@GetMapping("/greet/{name}")
	public String getGreetMsg(@PathVariable("name") String name) {
		String msg = name + ", Good Morning..!!";
		return msg;
	}

	@GetMapping("/welcome")
	public String getWelcomeMsg(@RequestParam("name") String name) {
		String msg = name + ", Welcome to REST API";
		return msg;
	}
}
