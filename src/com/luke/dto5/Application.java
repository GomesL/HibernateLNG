package com.luke.dto5;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class Application {
	
	public static SessionFactory sf;

	public static void main(String[] args) {
		
		User user = new User();
		user.setUserName("Gomes");
		Address addrH = new Address();
		addrH.setCity("AA");
		addrH.setPo("1");
		user.setHomeAddr(addrH);
				
		User user2 = new User();
		user2.setUserName("Nirmal");
		Address addrO = new Address();
		addrO.setCity("BB");
		addrO.setPo("5");
		user2.setOfficeAddr(addrO);
		
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
