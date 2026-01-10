package in.tejas.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.xpath;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class CustomerRestControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getCustomer_JSON() throws Exception {

        mockMvc.perform(get("/customer")
                .accept("application/json"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("John"))
                .andExpect(jsonPath("$.email").value("john@gmail.com"));
    }
    
    @Test
    void getCustomer_XML() throws Exception {

        mockMvc.perform(get("/customer")
                .accept("application/xml"))
                .andExpect(status().isOk())
                .andExpect(xpath("/Customer/id").string("1"))
                .andExpect(xpath("/Customer/name").string("John"))
                .andExpect(xpath("/Customer/email").string("john@gmail.com"));
    }

    @Test
    void getCustomers_JSON() throws Exception {

        mockMvc.perform(get("/customers")
                .accept("application/json"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(3))
                .andExpect(jsonPath("$[0].name").value("John"))
                .andExpect(jsonPath("$[1].name").value("Smith"))
                .andExpect(jsonPath("$[2].name").value("David"));
    }

    @Test
    void createCustomer_JSON() throws Exception {

        String jsonBody = """
            {
              "id": 10,
              "name": "Tejas",
              "email": "tejas@gmail.com"
            }
            """;

        mockMvc.perform(post("/customer")
                .contentType("application/json")
                .accept("text/plain")
                .content(jsonBody))
                .andExpect(status().isCreated())
                .andExpect(content().string("Customer Saved"));
    }
}
