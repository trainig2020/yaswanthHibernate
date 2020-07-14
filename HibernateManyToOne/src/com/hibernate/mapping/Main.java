package com.hibernate.mapping;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {
		UserDetails user = new UserDetails();
		user.setName("robo");
		
		BankDetails bank = new BankDetails();
		bank.setBname("SC");
		
		BankDetails bank1 = new BankDetails();
		bank1.setBname("Kotak");
		
//		user.getBankDetails().add(bank);
//		user.getBankDetails().add(bank1);
		
		List<BankDetails> lst = new ArrayList<BankDetails>();
		lst.add(bank);
		lst.add(bank1);
		user.setBankDetails(lst);
		
		bank.setDetails(user);
		bank1.setDetails(user);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
        session.save(bank);
		session.save(bank1);
		session.getTransaction().commit();
		session.close();

	}

}
