package com.luke.dto;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class Application {

	public static SessionFactory sf;
	
	public static void main(String[] args) {
		
		User user = new User();
		user.setUserId(4);
		user.setUserName("Nirmal");
		
//		@SuppressWarnings("deprecation")
//		SessionFactory sf = new Configuration().configure().buildSessionFactory();

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
		session.getTransaction().commit();
	}

}
