package servis;

import dao.AddTimDao;

public class AddTimService {
	
	AddTimDao dao = new AddTimDao();

	public void dodajTim(String nazivTima, String opis) {	
		dao.dodajTim(nazivTima, opis);
	}

}
