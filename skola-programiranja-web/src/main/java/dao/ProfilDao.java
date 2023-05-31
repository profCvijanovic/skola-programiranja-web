package dao;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import dto.ProfilDto;

public class ProfilDao {
	
	SessionFactory factory = new Configuration().configure().buildSessionFactory();
	
	public ProfilDto vratiProfilnePodatke(String idUser) {
		
		ProfilDto profil = new ProfilDto();
		
		Session sesija = factory.openSession();
		sesija.beginTransaction();	
			try {	
				String sql = "SELECT \r\n"
						+ "u.userName,\r\n"
						+ "z.sifraZaposlenog,\r\n"
						+ "ud.ime,\r\n"
						+ "ud.prezime,\r\n"
						+ "ud.drzava,\r\n"
						+ "ud.grad,\r\n"
						+ "ud.ulica,\r\n"
						+ "ud.postanskiBroj,\r\n"
						+ "t.naziv\r\n"
						+ "FROM user u\r\n"
						+ "INNER JOIN zaposleni z ON z.user_id = u.id\r\n"
						+ "INNER JOIN userdetails ud ON z.userDetails_id = ud.id\r\n"
						+ "INNER JOIN tim t ON z.tim_id = t.id\r\n"
						+ "WHERE u.id = :idUsera";
				Query query = sesija.createNativeQuery(sql);
					query.setParameter("idUsera", idUser);
					
				Object[] izBaze = (Object[])query.getSingleResult();
				
				if(izBaze[0] != null) {
					profil.setUserName(izBaze[0].toString());
				}
				
				if(izBaze[1] != null) {
					profil.setSifraZaposlenog(izBaze[1].toString());
				}
				
				if(izBaze[2] != null) {
					profil.setIme(izBaze[2].toString());
				}
				
				if(izBaze[3] != null) {
					profil.setPrezime(izBaze[3].toString());
				}
				
				if(izBaze[4] != null) {
					profil.setDrzava(izBaze[4].toString());
				}
				
				if(izBaze[5] != null) {
					profil.setGrad(izBaze[5].toString());
				}
				
				if(izBaze[6] != null) {
					profil.setUlica(izBaze[6].toString());
				}
				
				if(izBaze[7] != null) {
					profil.setPostanskiBroj(izBaze[7].toString());
				}
				
				if(izBaze[8] != null) {
					profil.setNazivTima(izBaze[8].toString());
				}
		
				System.out.println("Postoji profil za user id " + idUser);
				sesija.getTransaction().commit();
			}catch (Exception e) {
				System.out.println("Ne postoji profil!!!");
				profil =null;
				sesija.getTransaction().rollback();
			}		
			sesija.close();
		
		return profil;
	}

}
