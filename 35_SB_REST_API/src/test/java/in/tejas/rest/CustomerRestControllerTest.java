package in.tejas.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

//what about xml
// integration test
@WebMvcTest(CustomerRestController.class)
public class CustomerRestControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	
	@Test
	void testGetCustomer() throws Exception{
		
		mockMvc.perform(get("/customer")
				.accept("application/json"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.id").value(1))
		.andExpect(jsonPath("$.name").value("John"))
		.andExpect(jsonPath("$.email").value("john@gmail.com"));			
	}
	
	@Test
	void testGetCustomers() throws Exception {

	    mockMvc.perform(get("/customers")
	            .accept("application/json"))
	            .andExpect(status().isOk())
	            .andExpect(jsonPath("$.length()").value(3))
	            .andExpect(jsonPath("$[0].name").value("John"))
	            .andExpect(jsonPath("$[1].email").value("smith@gmail.com"))
	            .andExpect(jsonPath("$[2].id").value(3));
	}

	@Test
	void testCreateCustomer() throws Exception {

	    String jsonBody = """
	        {
	          "id": 10,
	          "name": "Tejas",
	          "email": "tejas@gmail.com"
	        }
	        """;

	    mockMvc.perform(post("/customer")
	            .contentType("application/json")
	            .content(jsonBody))
	            .andExpect(status().isCreated())
	            .andExpect(content().string("Customer Saved"));
	}
	
	@Test
	void testUpdateCustomer() throws Exception {

	    String jsonBody = """
	        {
	          "id": 1,
	          "name": "John",
	          "email": "john_new@gmail.com"
	        }
	        """;

	    mockMvc.perform(put("/customer")
	            .contentType("application/json")
	            .content(jsonBody))
	            .andExpect(status().isOk())
	            .andExpect(content().string("Customer Updated"));
	}
	
	@Test
	void testDeleteCustomer() throws Exception {

	    mockMvc.perform(delete("/customer/1"))
	            .andExpect(status().isOk())
	            .andExpect(content().string("Customer Deleted"));
	}


}
