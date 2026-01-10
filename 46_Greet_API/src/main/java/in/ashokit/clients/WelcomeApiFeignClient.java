package in.ashokit.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "WELCOME-API")   // it will act as client to welcome api

// <-- we are directly connecting to api not any fixed url
//implementation for below interface is done spring cloud
public interface WelcomeApiFeignClient {
	
	@GetMapping("/welcome")
	public String invokeWelcomeApi();
	
}
