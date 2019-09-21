package com.luv2code.hibernate.demo.entity;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchJoinDemo {

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
		
		// get instructor form db
		int theId=1;
		// create join query
		Query<Instructor> query = 
				session.createQuery("select i from Instructor i "
				+ "JOIN FETCH i.courses "
				+ "where i.id =:theInstructorId",Instructor.class);
		
		// set parameter
		query.setParameter("theInstructorId", theId);
		
		//get data from query
		Instructor tempInstructor = query.getSingleResult();
		
		System.out.println("instruct :" + tempInstructor);
		 
		// get course
		System.out.println("courses" + tempInstructor.getCourses());
		session.getTransaction().commit();
		session.close();
		// after clse
		System.out.println("coursessdfs" + tempInstructor.getCourses());
		
		// commit
		//session.getTransaction().commit();
		System.out.println("done");
	}
	finally {
		//session.close();
		factory.close();
	 }
	}

}
