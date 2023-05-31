package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import dto.TimDto;

public class TimDao {
	
	SessionFactory factory = new Configuration().configure().buildSessionFactory();
	

	public List<TimDto> vratiSveTimove() {
		
		List<TimDto> sviTimovi = new ArrayList<TimDto>();
		
		Session sesija = factory.openSession();
		sesija.beginTransaction();	
			try {	
				String sql = "SELECT\r\n"
						+ "naziv,\r\n"
						+ "opis\r\n"
						+ "FROM tim";
				Query query = sesija.createNativeQuery(sql);
						
				List<Object[]> izBaze = (List<Object[]>)query.getResultList();
				
				for(Object[] o: izBaze) {
					
					TimDto timDto = new TimDto();
					
					if(o[0] != null) {
						timDto.setNazivTima(o[0].toString());
					}
					
					if(o[1] != null) {
						timDto.setOpis(o[1].toString());
					}
					
					sviTimovi.add(timDto);
					
				}
				
				System.out.println("Postoji lista timova ");
				sesija.getTransaction().commit();
			}catch (Exception e) {
				System.out.println("Ne postoji lista timova!!!");
				sviTimovi = null;
				sesija.getTransaction().rollback();
			}		
			sesija.close();
		
		return sviTimovi;
	}

}
