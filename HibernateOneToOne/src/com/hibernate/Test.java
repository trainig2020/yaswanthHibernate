package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {
    public static void main(String[] args) {
		UserDetails user = new UserDetails();
		user.setName("yaswanth");
		
		Vehicle v = new Vehicle();
		v.setVname("car");
	
		user.setVehicle(v);
		
		
		SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.save(v);
		
		session.getTransaction().commit();
		session.close();
	}
}
