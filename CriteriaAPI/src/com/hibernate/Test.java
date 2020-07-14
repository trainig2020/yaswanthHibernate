package com.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

public class Test {
	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
        Criteria criteria = session.createCriteria(StudentDetails.class);
        
        
//        criteria.add(Restrictions.eq("sname", "Student9"))
//        .add(Restrictions.gt("stid", 5));
        
        
        criteria.add(Restrictions.or(Restrictions.between("stid", 0, 3), Restrictions.between("stid", 5, 10)));
        
        
		
		List student=criteria.list();
		session.getTransaction().commit();
		session.close();
		for (Object object : student) {
			System.out.println(object.toString());
		}
		System.out.println("Size of list is :"+ student.size());
	}
}
