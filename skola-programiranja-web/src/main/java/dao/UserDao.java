package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import dto.UserDto;

public class UserDao {
	
	SessionFactory factory = new Configuration().configure().buildSessionFactory();
	

	public List<UserDto> vratiSveUsere() {
		
		List<UserDto> sviUseri = new ArrayList<UserDto>();
		
		Session sesija = factory.openSession();
		sesija.beginTransaction();	
			try {	
				String sql = "SELECT \r\n"
						+ "id,\r\n"
						+ "userName,\r\n"
						+ "password,\r\n"
						+ "rola\r\n"
						+ "FROM user";
				Query query = sesija.createNativeQuery(sql);
						
				List<Object[]> izBaze = (List<Object[]>)query.getResultList();
				
				for(Object[] o: izBaze) {
					
					UserDto userDto = new UserDto();
					
					if(o[0] != null) {
						userDto.setId((int)o[0]);
					}
					
					if(o[1] != null) {
						userDto.setUserName(o[1].toString());
					}
					
					if(o[2] != null) {
						userDto.setPassword(o[2].toString());
					}
					
					if(o[3] != null) {
						userDto.setRola((int)o[3]);
					}else {
						userDto.setRola(null);
					}
					
					sviUseri.add(userDto);
					
				}
				
				System.out.println("Postoji lista usera ");
				sesija.getTransaction().commit();
			}catch (Exception e) {
				System.out.println("Ne postoji lista usera!!!");
				sviUseri = null;
				sesija.getTransaction().rollback();
			}		
			sesija.close();
		
		return sviUseri;
	}

}
