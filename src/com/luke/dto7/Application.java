package com.luke.dto7;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class Application {
	
	public static SessionFactory sf;

	public static void main(String[] args) {
		
		Address a1 = new Address();
		a1.setPo("50");
		a1.setCity("Matara");
		
		Address a2 = new Address();
		a2.setPo("69");
		a2.setCity("Galle");
		
		Address a3 = new Address();
		a3.setPo("20");
		a3.setCity("kandy");
		
		Address a4 = new Address();
		a4.setPo("19");
		a4.setCity("Kandana");
		
		User user = new User();
		user.setUserName("Gomes");
		user.getlOfAddresses().add(a1);
		user.getlOfAddresses().add(a2);
		user.getlOfAddresses().add(a3);
				
		User user2 = new User();
		user2.setUserName("Nirmal");
		user2.getlOfAddresses().add(a4);
		
		try{
			Configuration configuration = new Configuration().configure();
			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
			sf = configuration.buildSessionFactory(builder.build());
	      }catch (Throwable ex) { 
	         System.err.println("Failed to create sessionFactory object." + ex);
	         throw new ExceptionInInitializerError(ex); 
	    }
		
		Session session = sf.openSession();
		session.beginTransaction();
		session.save(user);
		session.save(user2);
		session.getTransaction().commit();
		session.close();

	}

}
