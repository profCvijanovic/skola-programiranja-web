package servis;

import dao.ProfilDao;
import dto.ProfilDto;

public class ProfilService {
	
	ProfilDao dao = new ProfilDao();

	public ProfilDto vratiProfilnePodatke(String idUser) {
		return dao.vratiProfilnePodatke(idUser);
	}

}
