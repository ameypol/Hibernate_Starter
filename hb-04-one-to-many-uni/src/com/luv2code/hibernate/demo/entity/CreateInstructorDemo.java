package com.luv2code.hibernate.demo.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
SessionFactory factory = new Configuration()
						.configure()
						.addAnnotatedClass(Instructor.class)
						.addAnnotatedClass(InstructorDetail.class)
						.addAnnotatedClass(Course.class)
						.buildSessionFactory();

Session session = factory.getCurrentSession();
session.beginTransaction();
	try {
		
		// create object
		Instructor tempInstructor =
			new	Instructor("amey","pol","amey.pol@nenu");
		
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
		session.close();
		factory.close();
	 }
	}

}
