package in.tejas.rest;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import in.tejas.rest.DemoRestController;

@WebMvcTest(DemoRestController.class)
public class DemoRestControllerTest {

		@Autowired
		private MockMvc mockmvc;
		
		@Test
		void testGetmsg() throws Exception{
			mockmvc.perform(get("/msg"))
			.andExpect(status().isOk())
			.andExpect(content().string("Welcome to Ashok IT"));
			
		}
		
		@Test
		void testGetGreetMsg() throws Exception{
			mockmvc.perform(get("/greet/tejas"))
			.andExpect(status().isOk())
			.andExpect(content().string("tejas, Good Morning..!!"));
		}
	//suppose we are checking status and content if content mismatch and status is correct then test fail?
		
		@Test
		void testGetWelcomeMsg() throws Exception {
		    mockmvc.perform(get("/welcome")
		            .param("name", "Tejas"))
		            .andExpect(status().isOk())
		            .andExpect(content().string("Tejas, Welcome to REST API"));
		}

}
