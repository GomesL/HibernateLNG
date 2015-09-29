package com.luke.dto3;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class Application {

	public static SessionFactory sf;
	
	public static void main(String[] args) {
		
		User user = new User();
		user.setUserId(2);
		user.setUserName("Gomes");
		user.setJoinedDate(new Date());
		user.setAddress("222");
		user.setDescription("ABC");
		
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
		session.close();
		
		user = null;
		session = sf.openSession();
		session.beginTransaction();
		user = (User) session.get(User.class, 2);
		System.out.println("User Name retrieved is "+user.getUserName());
	}

}
