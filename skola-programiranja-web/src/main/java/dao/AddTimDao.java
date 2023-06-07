package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Tim;


public class AddTimDao {
	
	SessionFactory factory = new Configuration().configure().buildSessionFactory();	

	public void dodajTim(String nazivTima, String opis) {
		
		Session sesija = factory.openSession();
		sesija.beginTransaction();	
			try {	
				Tim tim = new Tim();
				tim.setNaziv(nazivTima);
				tim.setOpis(opis);
				
				sesija.save(tim);			
				System.out.println("Tim je uspesno dodat u bazu...");
				sesija.getTransaction().commit();
			}catch (Exception e) {
				System.out.println("NIJE DODAT U BAZU TIM!");
				sesija.getTransaction().rollback();
			}		
			sesija.close();
	}

}
