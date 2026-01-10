package in.ashokit.service;

import in.ashokit.dao.IUserDao;

public class UserServiceImpl implements UserService {
	
	private IUserDao userDaoRef;
	
	public UserServiceImpl() {
		System.out.println("UserServiceImpl:: 0-param :: Constructor");
	}
	
	public UserServiceImpl(IUserDao userDao) {
		System.out.println("UserServiceImpl:: param :: Constructor");
		this.userDaoRef = userDao;
	}
	public void setUserDaoRef(IUserDao userDao) {
	    System.out.println("UserServiceImpl:: setUserDao() method called");
	    this.userDaoRef = userDao;
	}

	@Override
	public String getName(int id) {
		return userDaoRef.findName(id);
	}

}
