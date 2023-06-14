package servis;

import java.util.List;

import dao.InitUserDetailsDao;
import dao.TimDao;
import dto.PozicijaDto;
import dto.TimDto;
import dto.UserDetailsDto;

public class InitUserDetailsService {
	
	InitUserDetailsDao dao = new InitUserDetailsDao();
	TimDao timDao = new TimDao();

	public List<TimDto> vratiSveTimove() {
		return timDao.vratiSveTimove();
	}
	
	public List<PozicijaDto> vratiSvePozicije() {
		return dao.vratiSvePozicije();
	}

	public List<UserDetailsDto> vratiSveUserDetails() {
		return dao.vratiSveUserDetails();
	}

}
