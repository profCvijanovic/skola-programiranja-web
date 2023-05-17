package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.User;
import model.UserDetails;
import model.Zaposleni;

public class RegistracijaDao {
	
	
	SessionFactory factory = new Configuration().configure().buildSessionFactory();
	
	public void insertUser(User user) {
		
		Session sesija = factory.openSession();
				sesija.beginTransaction();	
					try {	
						// odradi operaciju
						sesija.save(user);
						System.out.println("Upisan user " + user.getUserName());
						sesija.getTransaction().commit();
					}catch (Exception e) {
						sesija.getTransaction().rollback();
					}		
		sesija.close();
		factory.close();
	}

}
