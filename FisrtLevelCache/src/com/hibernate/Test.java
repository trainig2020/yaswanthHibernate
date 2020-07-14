package com.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class Test {
	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		StudentDetails details = new StudentDetails();
		
		//This is called first level Cache i.e 
		//Below we created two objects for studentdetails but hibernate writes a select query for only one time.
		//So second object will excute the select query by using query present in cache.
		//So in console we can see only one select query for those two objects.
		
		StudentDetails student =(StudentDetails) session.get(StudentDetails.class, 1);
		StudentDetails student2 = (StudentDetails) session.get(StudentDetails.class, 1);
		session.getTransaction().commit();
		session.close();
		
		Session session2 =sessionFactory.openSession();
		session2.beginTransaction();
		StudentDetails student3 = (StudentDetails) session2.get(StudentDetails.class, 1);
		session2.getTransaction().commit();
		session2.close();
		
	}
}
