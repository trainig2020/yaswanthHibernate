package com.hiber.inheritance;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {
  public static void main(String[] args) {
	Vehicle vehicle = new Vehicle();
	vehicle.setVehicleName("car");
	
	TwoWheeler bike = new TwoWheeler();
	bike.setVehicleName("RoyalEnfeild");
	bike.setStreeringHandle("Bike StreeringHandle");
	FourWheeler car = new FourWheeler();
	car.setVehicleName("Audi");
	car.setStreeringWheel("car StreeringWheel");
	SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();
	Session session = sessionFactory.openSession();
	session.beginTransaction();
	session.save(vehicle);
	session.save(car);
	session.save(bike);
	session.getTransaction().commit();
	session.close();
	
}
}
 