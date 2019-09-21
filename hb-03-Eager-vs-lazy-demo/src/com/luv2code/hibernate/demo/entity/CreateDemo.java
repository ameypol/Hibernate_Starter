package com.luv2code.hibernate.demo.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
SessionFactory factory = new Configuration()
						.configure()
						.addAnnotatedClass(Instructor.class)
						.addAnnotatedClass(InstructorDetail.class)
						.buildSessionFactory();

Session session = factory.getCurrentSession();

	try {
	
		// create
		session.beginTransaction();
		
		// create object
		Instructor tempInstructor =
			new	Instructor("amey","pol","amey.po2nenu");
		
		InstructorDetail tempInstructorDetail = new
				InstructorDetail("http:code","luv2code");
		
		// associate to objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);
		
		//save object
		// this will save all objects 
		session.save(tempInstructor);
		
		// commit
		session.getTransaction().commit();
		System.out.println("done");
	}
	finally {
		factory.close();
	 }
	}

}
