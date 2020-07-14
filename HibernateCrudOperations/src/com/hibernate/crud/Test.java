package com.hibernate.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {
	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		// ******************Saving An object to Datbase**************************
//		for (int i = 0; i < 10; i++) {
//			StudentDetails s = new StudentDetails();
//			s.setSname("Student" + i);
//			s.setScity("City" + i);
//			session.save(s);
//		}

		// ************************reading an object fron Database****************

//		StudentDetails student = (StudentDetails) session.get(StudentDetails.class, 8);
//		System.out.println(student.getSname()+"---------"+ student.getScity());
//		session.save(student);

		// *************************Deleting an object from Database*****************

//		StudentDetails student = (StudentDetails) session.get(StudentDetails.class, 9);
//		session.delete(student);

		// *****************************updating an object from database**************

		StudentDetails student = (StudentDetails) session.get(StudentDetails.class, 8);
		System.out.println(student.getSname() + "---------" + student.getScity());
		student.setSname("Updated name");
		student.setScity("Updated City");
		session.update(student);
		System.out.println(student.getSname() + "---------" + student.getScity());

		session.getTransaction().commit();
		session.close();

	}
}
