package dao;


import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.User;

public class LoginDao {
	
	SessionFactory factory = new Configuration().configure().buildSessionFactory();


	public User vratiUseraPoUserNameIpassword(String userName, String password) {
		
		User user = new User();
		
		Session sesija = factory.openSession();
		sesija.beginTransaction();	
			try {	
				String hql = "from User where userName = :u and password = :p";
				Query query = sesija.createQuery(hql);
					query.setParameter("u", userName);
					query.setParameter("p", password);
				user = (User)query.getSingleResult();
				System.out.println("Postoji user " + userName);
				sesija.getTransaction().commit();
			}catch (Exception e) {
				System.out.println("Ne postoji user!!!");
				user = null;
				sesija.getTransaction().rollback();
			}		
			sesija.close();

		return user;
	}

}
