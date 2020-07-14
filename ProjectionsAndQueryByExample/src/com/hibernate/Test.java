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
		
		StudentDetails exampleStudent = new StudentDetails();
		exampleStudent.setSname("Student5");
		exampleStudent.setStid(5);	
		
		Example example = Example.create(exampleStudent);
		
		Criteria criteria = session.createCriteria(StudentDetails.class)
				                         .add(example);
		
//        Criteria criteria = session.createCriteria(StudentDetails.class)
//        		.setProjection(Projections.property("stid"))
//        		.addOrder(Order.desc("stid"));
		
		List student=criteria.list();
		session.getTransaction().commit();
		session.close();
		for (Object object : student) {
			System.out.println(object.toString());
		}
		System.out.println("Size of list is :"+ student.size());
	}
}
