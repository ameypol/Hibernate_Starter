package com.luv2code.hibernate.demo.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetInstructorDetailDemo {

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
		//save
		int theId = 2333;
		
		InstructorDetail getInstructor =
				session.get(InstructorDetail.class, theId);
		
		System.out.println("print ID "+ getInstructor);
		
		System.out.println("print ID instructor "+ getInstructor.getInstructor());
		
		// commit
		session.getTransaction().commit();
	System.out.println("done");
	}
	catch(Exception exc) {
		exc.printStackTrace();
	}
	finally {
		session.close();
		factory.close();
	 }
	}

}
