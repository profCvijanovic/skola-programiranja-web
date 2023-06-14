package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Pozicija;
import model.Rola;
import model.Tim;
import model.User;
import model.UserDetails;
import model.Zaposleni;

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


	public void snimiRola(String rola, String idUser) {
		Session sesija = factory.openSession();
		sesija.beginTransaction();	
			try {	
				
				Rola r = null;
				
				if(rola.equals("0")) {
					r = Rola.CHIEF;
				}else {
					r = Rola.PROGRAMMER;
				}
				
				User user = sesija.get(User.class, Integer.parseInt(idUser));
				
				user.setRola(r);
				
				sesija.update(user);
				
				System.out.println("Uspesno sacuvana rola...");
				sesija.getTransaction().commit();
			}catch (Exception e) {
				System.out.println("Neuspesno sacuvana rola...!!!");
				sesija.getTransaction().rollback();
			}		
			sesija.close();	
		
	}


	public void snimiZaposlenog(String plata, String sifraZaposlenog, String idTim, String idUser,
			String idUserDetails, String[] pozicija) {
		
		Session sesija = factory.openSession();
		sesija.beginTransaction();	
			try {	
				
				Zaposleni zaposleni = new Zaposleni();
				zaposleni.setPlata(Double.parseDouble(plata));
				zaposleni.setSifraZaposlenog(sifraZaposlenog);
				Tim tim = sesija.get(Tim.class, Integer.parseInt(idTim));
				zaposleni.setTim(tim);
				User user = sesija.get(User.class, Integer.parseInt(idUser));
				zaposleni.setUser(user);
				UserDetails userDetails = sesija.get(UserDetails.class, Integer.parseInt(idUserDetails));
				zaposleni.setUserDetails(userDetails);
				
				
				List<Pozicija> listaPozicija = new ArrayList<Pozicija>();
				
				for(int i = 0; i < pozicija.length; i++ ) {
					
					if(pozicija[i] != null && !pozicija[i].isEmpty()) {
						Pozicija p = sesija.get(Pozicija.class, Integer.parseInt(pozicija[i]));
						listaPozicija.add(p);
					}
				}
				
				if(listaPozicija != null && !listaPozicija.isEmpty()) {
					zaposleni.setPozicije(listaPozicija);
				}
				
				sesija.save(zaposleni);
				
				System.out.println("Uspesno sacuvan zaposleni...");
				sesija.getTransaction().commit();
			}catch (Exception e) {
				System.out.println("Neuspesno sacuvan zaposleni...!!!");
				sesija.getTransaction().rollback();
			}		
			sesija.close();	
		
		
	}

}
