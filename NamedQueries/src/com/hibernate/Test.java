package com.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {
	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Query query = session.getNamedQuery("StudentDetails.byId");
		query.setInteger(0, 6);
		
//		Query query = session.getNamedQuery("StudentDetails.byname");
//		query.setString(0, "student8");
		
		List student=query.list();
		session.getTransaction().commit();
		session.close();
		for (Object object : student) {
			System.out.println(object.toString());
		}
		System.out.println("Size of list is :"+ student.size());
	}
}
