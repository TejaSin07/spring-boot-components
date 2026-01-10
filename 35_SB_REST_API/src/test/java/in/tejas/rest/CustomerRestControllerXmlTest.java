package in.tejas.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.xpath;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(CustomerRestController.class)
public class CustomerRestControllerXmlTest {
	
	@Autowired
	private MockMvc mockMvc;
	//can we check both in one method
    @Test
    void testGetCustomer_XML() throws Exception {

        mockMvc.perform(get("/customer")
                .accept("application/xml"))
                .andExpect(status().isOk())
                .andExpect(xpath("/Customer/id").string("1"))
                .andExpect(xpath("/Customer/name").string("John"))
                .andExpect(xpath("/Customer/email").string("john@gmail.com"));
    }
    
    @Test
    void testGetCustomers_XML() throws Exception {

        mockMvc.perform(get("/customers")
                .accept("application/xml"))
                .andExpect(status().isOk())
                .andExpect(xpath("/*/*[1]/name").string("John"))
                .andExpect(xpath("/*/*[2]/email").string("smith@gmail.com"));
    }
    
    @Test
    void testCreateCustomer_XML() throws Exception {

        String xmlBody = """
            <Customer>
                <id>10</id>
                <name>Tejas</name>
                <email>tejas@gmail.com</email>
            </Customer>
            """;

        mockMvc.perform(post("/customer")
                .contentType("application/xml")
                .accept("text/plain")
                .content(xmlBody))
                .andExpect(status().isCreated());
    }
    
    
    
}


