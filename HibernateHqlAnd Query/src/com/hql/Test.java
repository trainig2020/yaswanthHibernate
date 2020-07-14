package com.hql;

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
		
		/*
		//HQL query creation and storing that result in query object.
		Query query=session.createQuery("from StudentDetails");
		
		//pagination in HQL.
		query.setFirstResult(1);
		query.setMaxResults(4);
		
		//printing all the values present in that query object.
		List student =query.list();
		session.getTransaction().commit();
		session.close();
		for (Object obj : student) {
			System.out.println(obj.toString());
		}
		System.out.println("size of list is:"+student.size());
		*/
         
		Query query =  session.createQuery("select sname from StudentDetails");
		query.setFirstResult(5);
		query.setMaxResults(3);
		List names=query.list();
		session.getTransaction().commit();
		session.close();
		for (Object object : names) {
			System.out.println(object.toString());
		}
		System.out.println("Size of list is :"+ names.size());
	}
}
