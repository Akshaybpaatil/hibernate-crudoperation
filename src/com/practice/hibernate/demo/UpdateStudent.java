package com.practice.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.practice.hibernate.demo.entity.Student;

public class UpdateStudent {

	public static void main(String[] args) {

		// create a session factory
		SessionFactory factory = new Configuration()
				                 .configure("hibernate.cfg.xml")
				                 .addAnnotatedClass(Student.class)
				                 .buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			
			int studentId = 1;
			
			//now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//retrieve student based on the id:primary key
			System.out.println("\nGetting student with id:"+studentId);
			
			Student myStudent = session.get(Student.class, studentId);
			
			System.out.println("Updating Student.....");
			myStudent.setFirstName("Sagar");
			
			//commit the transaction
			session.getTransaction().commit();
			
			//New Code
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//update email of all students
			System.out.println("update email of all students");
			
			session.createQuery("update Student s set s.email='sagarpatil.39@gmail.com'"
					+ "where s.id='1'").executeUpdate();
			
			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}
		finally {
			factory.close();
		}
	}

}
