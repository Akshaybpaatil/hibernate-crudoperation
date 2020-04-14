package com.practice.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.practice.hibernate.demo.entity.Student;

public class ReadStudent {

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
			
			Student student = new Student("Sada","Shiv","sadashiv .39@gmail.com");
			
			//start the transaction
			session.beginTransaction();
			
			//save the student object
			System.out.println("Saving the student....");
			System.out.println(student);
			session.save(student);
			
			//commit transaction
			session.getTransaction().commit();
			
			//find the student id:primary key
			System.out.println("Saved student Generated id:"+student.getId());
			
			//now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//retrieve student based on the id:primary key
			System.out.println("\nGetting student with id:"+student.getId());
			
			Student myStudent = session.get(Student.class, student.getId());
			
			System.out.println("Get Complete:"+myStudent);
			
			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}
		finally {
			factory.close();
		}
	}

}
