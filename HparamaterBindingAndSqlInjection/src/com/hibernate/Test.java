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
//		
//		String minUserID = "5 or 1 = 1";//This is called Sql injection.
//		Query query =  session.createQuery("from StudentDetails where stid>"+ minUserID );
//		
		String minSid = "6";
		String studentname="Student9";
		
//		Query query = session.createQuery("from StudentDetails where stid > ? and sname = ?");
//		query.setInteger(0, Integer.parseInt(minSid));
//		query.setString(1, studentname);
		
		Query query = session.createQuery("from StudentDetails where stid >:stid and sname =:sname");
		query.setInteger("stid", Integer.parseInt(minSid));
		query.setString("sname", studentname);
		List names=query.list();
		session.getTransaction().commit();
		session.close();
		for (Object object : names) {
			System.out.println(object.toString());
		}
		System.out.println("Size of list is :"+ names.size());
	}
}
