package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Tim;


public class DeleteTimDao {
	
	SessionFactory factory = new Configuration().configure().buildSessionFactory();	

	public void deleteTim(String id) {
		
		Session sesija = factory.openSession();
		sesija.beginTransaction();	
			try {	
				
				Tim timIzBazeZaDelete = sesija.get(Tim.class, Integer.parseInt(id));
				
				sesija.delete(timIzBazeZaDelete);
							
				System.out.println("Tim je obrisan...");
				sesija.getTransaction().commit();
			}catch (Exception e) {
				System.out.println("NIJE OBRISAN TIM!");
				sesija.getTransaction().rollback();
			}		
			sesija.close();
	}

}
