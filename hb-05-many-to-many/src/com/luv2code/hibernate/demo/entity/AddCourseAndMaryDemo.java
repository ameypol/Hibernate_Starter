package com.luv2code.hibernate.demo.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddCourseAndMaryDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
SessionFactory factory = new Configuration()
						.configure()
						.addAnnotatedClass(Instructor.class)
						.addAnnotatedClass(InstructorDetail.class)
						.addAnnotatedClass(Course.class)
						.addAnnotatedClass(Review.class)
						.addAnnotatedClass(Student.class)
						.buildSessionFactory();

Session session = factory.getCurrentSession();

	try {
		session.beginTransaction();
	
		// create
		int theId=2;
		
		// create student
		Student mary=session.get(Student.class, theId);
		System.out.println("ame "+ mary);
		System.out.println("ame course"+ mary.getCourses());

		// create course
		Course course1 =new Course("rube1");
		Course course2= new Course("rube2");
		
		// add student to course
		course1.add(mary);
		course2.add(mary);
		
		// save course
		session.save(course1);
		session.save(course2);

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
