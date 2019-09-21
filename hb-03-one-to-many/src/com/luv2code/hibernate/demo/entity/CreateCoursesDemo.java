package com.luv2code.hibernate.demo.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCoursesDemo {

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
		Instructor tempInstructor =
				session.get(Instructor.class, theId);
		
		// create some course
		Course temp1Course1 = new Course("any1 course");
		Course temp1Course2 = new Course("any2 course");
		
		// add/set to course
		temp1Course1.setInstructor(tempInstructor);
		temp1Course2.setInstructor(tempInstructor);
		
		//add/set to instructor
		tempInstructor.add(temp1Course1);
		tempInstructor.add(temp1Course2);
		
		// save
		session.save(temp1Course1);
		session.save(temp1Course2);
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
