package com.luv2code.hibernate.demo.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
SessionFactory factory = new Configuration()
						.configure()
						.addAnnotatedClass(Student.class)
						.buildSessionFactory();

Session session = factory.getCurrentSession();

	try {
		Student studenta = new Student("aAmeya","fPolb","damey.pol86@gmail.com");
		Student studentb = new Student("sAmeyv","cPolv","samey.pol86@gmail.comm");
		Student studentc= new Student("dAmeyc","vPola","aamey.pol86@gmail.comb");
		
		// create
		session.beginTransaction();
		//save
		session.save(studenta);
		session.save(studentb);
		session.save(studentc);
		
		// commit
		session.getTransaction().commit();
	System.out.println("done");
	}
	finally {
		factory.close();
	 }
	}

}
