package servis;

import dao.DeleteTimDao;

public class DeleteTimService {
	
	DeleteTimDao dao = new DeleteTimDao();

	public void deleteTim(String id) {
		dao.deleteTim(id);
	}


}
