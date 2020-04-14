package com.practice.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.practice.hibernate.demo.entity.Student;

public class CreateStudent {

	public static void main(String[] args) {

		// create a session factory
		SessionFactory factory = new Configuration()
				                 .configure("hibernate.cfg.xml")
				                 .addAnnotatedClass(Student.class)
				                 .buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			//create a student object
			System.out.println("Creating a new Student object...");
			
			Student student = new Student("Akshay","Patil","akshaybpatil.39@gmail.com");
			
			//start the transaction
			session.beginTransaction();
			
			//save the student object
			System.out.println("Saving the student....");
			session.save(student);
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}
		finally {
			factory.close();
		}
	}

}
