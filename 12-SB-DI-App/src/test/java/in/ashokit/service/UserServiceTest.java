package in.ashokit.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.boot.test.context.SpringBootTest;

import in.ashokit.dao.UserDao;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
	
	@Mock
	private UserDao userDao;
	
	@InjectMocks
	private UserService userService;
	
	
	@Test
	void testGetName_WhenIdIs100(){
		when(userDao.findName(100)).thenReturn("John");
		String userName = userService.getName(100);
		assertEquals("John", userName);
	}
	
	  @Test
	    void testGetName_WhenIdIsOtherThan100() {
	        when(userDao.findName(200)).thenReturn("Smith");

	        String userName = userService.getName(200);

	        assertEquals("Smith", userName);
	    }
	
}
