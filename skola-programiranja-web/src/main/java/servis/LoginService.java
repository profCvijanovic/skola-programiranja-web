package servis;

import dao.LoginDao;
import model.User;
import validacija.Validacija;

public class LoginService {
	
	Validacija validacija = new Validacija();
	LoginDao dao = new LoginDao();
	
	public boolean proveriDaLiSuParametriOk(String userName, String password) {
		return validacija.proveriDaLiSuParametriOk(userName, password);
	}

	public User vratiUseraPoUserNameIpassword(String userName, String password) {
		return dao.vratiUseraPoUserNameIpassword(userName, password);
	}



}
