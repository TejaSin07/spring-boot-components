package in.ashokit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import in.ashokit.service.UserService;

@SpringBootTest
class UserIntegrationTest {

    @Autowired
    private UserService userService;

    @Test
    void testGetName_EndToEnd() {
        String name = userService.getName(100);

        assertEquals("John", name);
    }
}
