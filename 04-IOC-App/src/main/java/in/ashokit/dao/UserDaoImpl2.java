package in.ashokit.dao;

public class UserDaoImpl2 implements IUserDao {

	
	public UserDaoImpl2() {
		System.out.println("UserDaoImpl::Constructor");
	}

	@Override
	public String findName(int id) {

		// db logic comes here

		if (id == 100) {
			return "Raju2";
		} else if (id == 101) {
			return "Rani2";
		}

		return null;
	}

}