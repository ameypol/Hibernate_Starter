package com.luv2code.hibernate.demo.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndReviewDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
SessionFactory factory = new Configuration()
						.configure()
						.addAnnotatedClass(Instructor.class)
						.addAnnotatedClass(InstructorDetail.class)
						.addAnnotatedClass(Course.class)
						.addAnnotatedClass(Review.class)
						.buildSessionFactory();

Session session = factory.getCurrentSession();

	try {
		session.beginTransaction();
	
		// create
		Course tempCourse = new Course("adding 3 course");
	
		//add review
	tempCourse.add(new Review("good review"));
	tempCourse.add(new Review("very good review"));
	tempCourse.add(new Review("better review"));
	tempCourse.add(new Review("excell review"));
		
	// save course
	session.save(tempCourse);
		
		//commit
		session.getTransaction().commit();
		System.out.println("done");
	}
	finally {
		session.close();
		factory.close();
	 }
	}

}
