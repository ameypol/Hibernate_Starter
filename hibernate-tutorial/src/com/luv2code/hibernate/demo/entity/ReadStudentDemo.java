package com.luv2code.hibernate.demo.entity;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
SessionFactory factory = new Configuration()
						.configure()
						.addAnnotatedClass(Student.class)
						.buildSessionFactory();

Session session = factory.getCurrentSession();

	try {
		Student studenta = new Student("aAmeya","fPolb","damey.pol86@gmail.com");
		//Student studentb = new Student("sAmeyv","cPolv","samey.pol86@gmail.comm");
		//Student studentc= new Student("dAmeyc","vPola","aamey.pol86@gmail.comb");
		
		// create
		session.beginTransaction();
		//save
		session.save(studenta);
		//session.save(studentb);
		//session.save(studentc);
		
		Student theStudent = session.get(Student.class, studenta.getId());
		List<Student> theStudent1 =session.createQuery("from Student s where s.firstName='aAmeya'").getResultList();
		displayStudents(theStudent1);
		System.out.println("id is " + theStudent); 
		//update one way
		theStudent.setFirstName("amey");
		session.update(theStudent);
		System.out.println("id is " + theStudent);
		
		//update 2nd way
		session.createQuery("update Student set email='fool@gmail.com'").executeUpdate(); 
		
		 List<Student> theStudent6 = session.createQuery("from Student").getResultList();
		 displayStudents(theStudent6);
		 
	    // delete 
		 session.createQuery("delete from Student where id=2").executeUpdate();
		 
		 session.delete(theStudent);
		 System.out.println("del obj is"+theStudent);
		 
		 // commit displayStudents(theStudent6);
		session.getTransaction().commit();
		
	System.out.println("done");
	}
	finally {
		factory.close();
	 }
	}

	private static void displayStudents(List<Student> theStudentx) {
		for(Student thestudents : theStudentx)
		{
		System.out.println(thestudents);
	}
	}

}
