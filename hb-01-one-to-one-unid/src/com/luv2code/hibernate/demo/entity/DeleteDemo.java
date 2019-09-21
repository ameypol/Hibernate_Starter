package com.luv2code.hibernate.demo.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {

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
		int theId = 1;
		
		Instructor deleteInstructor =
				session.get(Instructor.class, theId);
		
		if(deleteInstructor !=null)
			{System.out.println(" "+ deleteInstructor);
		session.delete(deleteInstructor);
			}
		else {
			System.out.println("null");
		}
		// commit
		session.getTransaction().commit();
	System.out.println("done");
	}
	finally {
		factory.close();
	 }
	}

}
