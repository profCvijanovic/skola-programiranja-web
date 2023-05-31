package servis;

import java.util.List;

import dao.TimDao;
import dto.TimDto;

public class TimService {
	
	TimDao dao = new TimDao();

	public List<TimDto> vratiSveTimove() {
		return dao.vratiSveTimove();
	}

}
