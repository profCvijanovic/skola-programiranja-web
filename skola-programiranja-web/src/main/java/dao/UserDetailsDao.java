package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.UserDetails;

public class UserDetailsDao {
	
	SessionFactory factory = new Configuration().configure().buildSessionFactory();
	

	public void snimiUserDetails(UserDetails userDetails) {
			
		Session sesija = factory.openSession();
		sesija.beginTransaction();	
			try {	
				sesija.save(userDetails);
				System.out.println("Uspesno sacuvan user details...");
				sesija.getTransaction().commit();
			}catch (Exception e) {
				System.out.println("Neuspesno sacuvan user details...!!!");
				sesija.getTransaction().rollback();
			}		
			sesija.close();	
	}

}
