package com.luv2code.hibernate.demo.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCoursesDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
SessionFactory factory = new Configuration()
						.configure()
						.addAnnotatedClass(Instructor.class)
						.addAnnotatedClass(InstructorDetail.class)
						.addAnnotatedClass(Course.class)
						.buildSessionFactory();

Session session = factory.getCurrentSession();

	try {
		session.beginTransaction();
		
		// get course form db
		int theId=10;
		Course tempCourse =session.get(Course.class, theId);
		//delete
		session.delete(tempCourse);
	
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
