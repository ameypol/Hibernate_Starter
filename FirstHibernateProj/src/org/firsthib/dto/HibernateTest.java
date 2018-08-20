package org.firsthib.dto;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 UserDetails user =new UserDetails();
 UserDetails user2 =new UserDetails();

 Vehicle vehicle=new Vehicle();
 vehicle.setVehicleName("car");
 
 Vehicle vehicle2=new Vehicle();
 vehicle2.setVehicleName("jeep");
 
 user.getVehicl2().add(vehicle);
 user.getVehicl2().add(vehicle2);
 
 vehicle.setUser(user);
 vehicle2.setUser(user);

 //user2.getVehicl2().add(vehicle);
 //user2.getVehicl2().add(vehicle2);
 
 user.setUserName("Amey");
 Address adress=new Address();
 adress.setStreet("dproad");
 adress.setCity("pune");
 adress.setPincode("411045");
 adress.setState("maharashtra");
 user.setHomeaddress(adress);
 user.setDescription("in maharashtra");
 user.setJoinedDate(new Date());
user.setOfficeaddress(adress);
 user.setVehicle(vehicle);
 
 
 
 user2.setUserName("Pradnya");
 Address adress1=new Address();
 adress1.setStreet("dproad");
 adress1.setCity("pune");
 adress1.setPincode("411045");
 adress1.setState("maharashtra");
 user2.setHomeaddress(adress1);
 user2.setOfficeaddress(adress1);
 user2.setDescription("in maharashtra");
 user2.setJoinedDate(new Date());
 user.getListofAddress().add(adress);// get the list defined for the user and then implement add method on thi s list
 user2.getListofAddress().add(adress1);
 //user2.setVehicle(vehicle);
 
 	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
 	Session session =sessionFactory.openSession(); // create new session
	 session.beginTransaction(); 
	 session.save(vehicle2);
	 session.save(vehicle);
	 session.save(user); 
	 session.save(user2);
	 
	 session.getTransaction().commit();
	 session.close(); 
	 
//	 user=null;
//	 session = sessionFactory.openSession(); // start new session
//	 session.beginTransaction(); 
//	 System.out.println("transation started");
//	 user = (UserDetails) session.get(UserDetails.class, 7);
//	
//	System.out.println("system returened data " + user.getUserName());
//	session.close();
//	
	}

}
