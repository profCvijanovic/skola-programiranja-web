package servis;

import dao.UserDetailsDao;
import model.UserDetails;

public class UserDetailsService {
	
	UserDetailsDao dao = new UserDetailsDao();

	public void snimiUserDetails(UserDetails userDetails) {
		dao.snimiUserDetails(userDetails);	
	}
	

}
