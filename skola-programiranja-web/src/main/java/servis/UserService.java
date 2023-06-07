package servis;

import java.util.List;

import dao.UserDao;
import dto.UserDto;

public class UserService {
	
	UserDao dao = new UserDao();

	public List<UserDto> vratiSveUsere() {
		return dao.vratiSveUsere();
	}

}
