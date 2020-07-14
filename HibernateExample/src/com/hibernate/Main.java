package com.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class Main {
	public static void main(String[] args) {
		StudentDetails s =new StudentDetails();
		s.setSname("yaswanth");
		s.setJoinedDate(new Date());
		
		Address addr = new Address();
		addr.setCity("kothapeta");
		addr.setPincode(533223);
		addr.setState("AndhraPradesh");
		
		//s.setHome_Address(addr);
		
		Address addr2 = new Address();
		addr2.setCity("vijyawada");
		addr2.setPincode(522332);
		addr2.setState("AndhraPradesh");
		
		//s.setOffice_Address(addr2);
		
		s.getListOfAddresses().add(addr);
		s.getListOfAddresses().add(addr2);
		
		
		SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(s);
		session.getTransaction().commit();
		session.close();
	}
}
