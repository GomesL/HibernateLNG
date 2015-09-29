package com.luke.dto5;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Application {

	public static void main(String[] args) {
		
		User user = new User();
		user.setUserName("Gomes");
		Address addrH = new Address();
		addrH.setCity("AA");
		addrH.setPo("1");
		user.setHomeAddr(addrH);
		Address addrO = new Address();
		addrO.setCity("BB");
		addrO.setPo("5");
		user.setOfficeAddr(addrO);
		
		User user2 = new User();
		user2.setUserName("Nirmal");
		
		@SuppressWarnings("deprecation")
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		session.save(user);
		session.save(user2);
		session.getTransaction().commit();
		session.close();

	}

}
