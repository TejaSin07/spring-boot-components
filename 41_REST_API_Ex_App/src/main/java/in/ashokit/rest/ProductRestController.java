package in.ashokit.rest;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.binding.Product;
import in.ashokit.exception.ExInfo;
import in.ashokit.exception.ProductNotFoundException;

@RestController
public class ProductRestController {

	@GetMapping("/product/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable("id") Integer id) throws Exception {
		if (id == 1) {
			Product p = new Product();
			p.setId(1);
			p.setName("Mouse");
			p.setPrice(500.50);
			return new ResponseEntity<>(p, HttpStatus.OK);
		} else {
			throw new ProductNotFoundException("Invalid Id");
		}
	}
	//try by commenting below we get changed ExCode ,which came from global exception handler
	 @ExceptionHandler(ProductNotFoundException.class)
	    public ResponseEntity<ExInfo> handleProductNotFound(ProductNotFoundException pe) {
	        ExInfo info = new ExInfo();
	        info.setExCode("SBI000xx");
	        info.setExMsg(pe.getMessage());
	        info.setExDate(LocalDate.now());

	        return new ResponseEntity<>(info, HttpStatus.BAD_REQUEST);
	    }
}





