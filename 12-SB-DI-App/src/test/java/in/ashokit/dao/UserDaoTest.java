package in.ashokit.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class UserDaoTest {

    @Test
    void testFindName_WhenIdIs100() {
        UserDao userDao = new UserDao();

        String name = userDao.findName(100);

        assertEquals("John", name);
    }

    @Test
    void testFindName_WhenIdIsNot100() {
        UserDao userDao = new UserDao();

        String name = userDao.findName(200);

        assertEquals("Smith", name);
    }
}
