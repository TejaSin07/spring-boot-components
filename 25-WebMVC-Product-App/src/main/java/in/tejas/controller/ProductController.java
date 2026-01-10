package in.tejas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import in.tejas.entity.Product;
import in.tejas.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;

// load form - GET
//	@GetMapping("/")
//	public ModelAndView loadForm() {
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("pobj", new Product());// for form binding
//		mav.setViewName("index");
//		return mav;
//	}
	
	 @GetMapping("/a")  
	 @ResponseBody   //try by un-commenting this 
	 public String login(Model model) {
	 	model.addAttribute("pobj",new Product());
	 	return "index";
	 }
//	 this code also works same as above code
//	 save product - POST
	 
	 
	@PostMapping("/product")
	public ModelAndView saveProduct(Product pobj) {
		ModelAndView mav = new ModelAndView();

		boolean status = productService.saveProduct(pobj);
		if (status) {
			mav.addObject("smsg", "Product Saved");
		} else {
			mav.addObject("emsg", "Failed to save");
		}

		mav.addObject("pobj", new Product());// for form binding
		//if we dont give above line then error will come .
		//as we are sendinng request to same form ,which require binding 
		//i.e now we are sending request two time and doing binding two time
		mav.setViewName("index");
		return mav;
	}

	// get products - GET
	@GetMapping("/products")
	public ModelAndView viewProducts() {
		List<Product> productsList = productService.getAllProducts();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("plist", productsList);
		mav.setViewName("data");

		return mav;
	}
}






