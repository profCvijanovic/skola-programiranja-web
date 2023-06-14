package servis;

import dao.UserDetailsDao;
import model.UserDetails;

public class UserDetailsService {
	
	UserDetailsDao dao = new UserDetailsDao();

	public void snimiUserDetails(UserDetails userDetails) {
		dao.snimiUserDetails(userDetails);	
	}

	public void snimiRola(String rola, String idUser) {
		dao.snimiRola(rola, idUser);
	}

	public void snimiZaposlenog(String plata, String sifraZaposlenog, String idTim, String idUser,
			String idUserDetails, String[] pozicija) {
		dao.snimiZaposlenog(plata, sifraZaposlenog, idTim, idUser, idUserDetails, pozicija);
		
	}
	

}
