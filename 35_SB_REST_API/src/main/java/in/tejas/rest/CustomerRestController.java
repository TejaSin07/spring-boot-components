package in.tejas.rest;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.tejas.binding.Customer;

//below we are creating provider

@RestController
public class CustomerRestController {

	
	@PutMapping(
			value = "/customer", 
			consumes = "application/json",
			produces = "text/plain"
	)
	public ResponseEntity<String> updateCustomer(@RequestBody Customer c) {
		// TODO : update customer in db
		return new ResponseEntity<>("Customer Updated", HttpStatus.OK);
	}

	@DeleteMapping(
			value="/customer/{cid}",
			produces ="text/plain"
	)
	public ResponseEntity<String> deleteCustomer(@PathVariable("cid") Integer cid) {
		// TODO : delete customer by putting logic here
		return new ResponseEntity<>("Customer Deleted", HttpStatus.OK);
	}

	@PostMapping(
			value = "/customer", 
			consumes ={"application/xml" , "application/json", "text/plain"}	,// it is taking input in json/xml format
			produces = {"application/xml" , "application/json","text/plain"}	// it is sending data in text formmat
	)
	public ResponseEntity<String> createCustomer(@RequestBody Customer c) {//Without @RequestBody, Spring won't convert JSON to Java objects properly.
		System.out.println(c);
		// TODO: insert into db
		return new ResponseEntity<>("Customer Saved", HttpStatus.CREATED);//"201" record is created 
	}

	@GetMapping(
			value = "/customers", 
			produces =  {"application/json", "application/xml"}
	)
	public ResponseEntity<List<Customer>> getCustomers() {
		Customer c1 = new Customer(1, "John", "john@gmail.com");
		Customer c2 = new Customer(2, "Smith", "smith@gmail.com");
		Customer c3 = new Customer(3, "David", "david@gmail.com");
		
		//above data currently we are putting manually to send response
		List<Customer> list = Arrays.asList(c1, c2, c3);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping(
			value = "/customer", 
			produces =  {"application/xml" , "application/json"}
	)
	public ResponseEntity<Customer> getCustomer() {
		Customer c = new Customer(1, "John", "john@gmail.com");
		return new ResponseEntity<>(c, HttpStatus.OK);
	}
}
