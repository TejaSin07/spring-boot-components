package in.tejas.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import in.tejas.binding.Product;
import reactor.core.publisher.Mono;

@Service
public class ProductService {
	
	
	public Mono<Product> getProductNew(){
		
		String apiUrl = "https://api.restful-api.dev/objects/2";
		
		WebClient webclient = WebClient.create();
		
		 return webclient.get()
						 .uri(apiUrl)
						 .retrieve()
						 .bodyToMono(Product.class); //in controlller return type should be Momo<class>
		
	}
//	What it does:
//
//		It gets the raw JSON response from the API as a plain string.
//		No mapping is done to any Java object.
//		Use case:
//		When you want to log, debug, or process the response manually.
//		Suitable when you don't have or need a specific Java class to map to.

	public Mono<String> getProduct() {

		String apiUrl = "https://api.restful-api.dev/objects/1";

		// getting webclient impl class obj
		WebClient webClient = WebClient.create();
		
		
        Mono<String> bodyToMono = webClient.get() // send GET req
										   .uri(apiUrl) // provider url
										   .retrieve() // get response body
										   .bodyToMono(String.class); // map response       
        									//in controlller return type should be Momo<String>
		
		return bodyToMono;
	}
		
//		What it does:
//
//			It deserializes the JSON response into a Product Java object using Jackson (or another JSON parser configured in Spring).
//
//			The Product class must match the structure of the JSON response.
//
//			Use case:
//
//			When you want to work with structured data in your application.
//
//			Enables type-safe access like product.getName() or product.getData().getPrice().

}






