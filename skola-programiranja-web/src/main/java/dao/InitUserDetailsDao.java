package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import dto.PozicijaDto;

public class InitUserDetailsDao {
	
	SessionFactory factory = new Configuration().configure().buildSessionFactory();
	

	public List<PozicijaDto> vratiSvePozicije() {
		
		List<PozicijaDto> svePozicije = new ArrayList<PozicijaDto>();
		
		Session sesija = factory.openSession();
		sesija.beginTransaction();	
			try {	
				String sql = "select\r\n"
						+ "id,\r\n"
						+ "naziv\r\n"
						+ "from\r\n"
						+ "pozicija";
				Query query = sesija.createNativeQuery(sql);
						
				List<Object[]> izBaze = (List<Object[]>)query.getResultList();
				
				for(Object[] o: izBaze) {
					
					PozicijaDto pozicijaDto = new PozicijaDto();
					
					if(o[0] != null) {
						pozicijaDto.setId((int)o[0]);
					}
					
					if(o[1] != null) {
						pozicijaDto.setNazivPozicije(o[1].toString());
					}		
					
					svePozicije.add(pozicijaDto);
					
				}
				
				System.out.println("Postoji lista pozicija ");
				sesija.getTransaction().commit();
			}catch (Exception e) {
				System.out.println("Ne postoji lista pozicija!!!");
				svePozicije = null;
				sesija.getTransaction().rollback();
			}		
			sesija.close();
		
		return svePozicije;
	}

}
