package servis;

import dao.EditTimDao;

public class EditTimService {
	
	EditTimDao dao = new EditTimDao();

	public void editTim(String id, String noviNazivTima, String noviOpis) {
		dao.editTim(id, noviNazivTima, noviOpis);
	}


}
