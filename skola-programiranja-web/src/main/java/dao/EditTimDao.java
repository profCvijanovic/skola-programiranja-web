package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Tim;


public class EditTimDao {
	
	SessionFactory factory = new Configuration().configure().buildSessionFactory();	

	public void editTim(String id, String noviNazivTima, String noviOpis) {
		
		Session sesija = factory.openSession();
		sesija.beginTransaction();	
			try {	
				
				Tim timIzBazeZaEdit = sesija.get(Tim.class, Integer.parseInt(id));
				
				if(noviNazivTima != null && !noviNazivTima.equals("")) {
					timIzBazeZaEdit.setNaziv(noviNazivTima);
				}
				
				if(noviOpis != null && !noviOpis.equals("")) {
					timIzBazeZaEdit.setOpis(noviOpis);
				}

				sesija.update(timIzBazeZaEdit);
							
				System.out.println("Tim je editovan...");
				sesija.getTransaction().commit();
			}catch (Exception e) {
				System.out.println("NIJE EDITOVAN TIM!");
				sesija.getTransaction().rollback();
			}		
			sesija.close();
	}

}
