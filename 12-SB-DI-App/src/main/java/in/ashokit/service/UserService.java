package in.ashokit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.dao.UserDao;

@Service
public class UserService {
   
	//field
	@Autowired
	private UserDao userDao;

//	public UserService() {
//		System.out.println("0 param constructor");
//	}
//
//	//constructor
//	@Autowired
//	public UserService(UserDao userDao) {
//		this.userDao = userDao;
//	}

	//setter
	@Autowired
	public void setUserDao(UserDao var) {
		this.userDao = var;
	}

	public  String getName(int id) {
		String findName = userDao.findName(id);
//		System.out.println("Name ::" + findName);
		return findName;
	}

}
