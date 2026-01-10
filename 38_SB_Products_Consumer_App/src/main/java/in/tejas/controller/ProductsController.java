 package in.tejas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import in.tejas.response.Product;
import in.tejas.service.ProductsService;


//@RestController
//public class ProductsController {
//
//	@Autowired
//	private ProductsService service;
//	
//	@GetMapping("/product")
//	public Product getProduct(@RequestParam("pid") String pid) {
//		
//		Product product = service.getProduct(pid);
//		
//		return product;
//	}
//
//	@GetMapping("/")
//	public String index(@ModelAttribute Product p, Model model) {
//		return "index";
//	}
//}

@Controller
public class ProductsController {

	@Autowired//
	private ProductsService service;
	
	@GetMapping("/product")
	public String getProduct(@RequestParam("pid") String pid, Model model) {
		
		Product product = service.getProduct(pid);
		
		model.addAttribute("p", product);
		
		return "index";
	}
	
	
	
	@GetMapping("/")
	public String index(@ModelAttribute("p") Product p, Model model) {
		return "index";
	}
	 @GetMapping("/api/product")
	 @ResponseBody
	 public Product getProduct(@RequestParam("pid") String pid) {
        return service.getProduct(pid);
	 }
}







