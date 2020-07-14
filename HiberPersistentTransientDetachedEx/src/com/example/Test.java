package com.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {
	public static void main(String[] args) {
        StudentDetails std = new StudentDetails();
        std.setSname("yaswanth");
        // at this stage object is transient.
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
	    session.save(std);
	    // at here the object is persistent and hibernate takes of that object.
	    std.setSname("nihkil");
	    std.setSname("sai");
		session.getTransaction().commit();
		session.close();
		//at this stage the object is detached so hibernate wont do any operations to that object.
		std.setSname("Final");

	}
}
