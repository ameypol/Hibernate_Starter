package com.luv2code.hibernate.demo.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndStudentDemo {

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
		Course tempCourse = new Course("adding 3 course");
		// save course
		session.save(tempCourse);
		
		Student student1=new Student("amey","pol","good review");
		Student student2=new Student("ame","po","very good review");
		Student student3=new Student("am","p","better review");
		Student student4=new Student("a","null","excell review");
				
		//add review
	tempCourse.add(student1);
	tempCourse.add(student2);
	tempCourse.add(student3);
	tempCourse.add(student4);
		
	// save student
	session.save(student1);
	session.save(student2);
	session.save(student3);
	session.save(student4);
		
	System.out.println("students"+ tempCourse.getStudents());
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
