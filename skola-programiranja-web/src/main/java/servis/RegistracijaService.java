package servis;

import dao.RegistracijaDao;
import model.User;
import validacija.Validacija;

public class RegistracijaService {
	
	Validacija validacija = new Validacija();
	RegistracijaDao dao = new RegistracijaDao();

	public boolean daLiJePassIstiKaoRepeatedPass(String password, String repeatedPassword) {
		return validacija.daLiJePassIstiKaoRepeatedPass(password, repeatedPassword);
	}
	
	public void insertUser(String userName, String password) {
		User user = new User();
		user.setUserName(userName);
		user.setPassword(password);
		dao.insertUser(user);
	}

}
