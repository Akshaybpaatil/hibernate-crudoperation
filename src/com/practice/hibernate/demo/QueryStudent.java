package com.practice.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.practice.hibernate.demo.entity.Student;

public class QueryStudent {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		// create a session factory
		SessionFactory factory = new Configuration()
				                 .configure("hibernate.cfg.xml")
				                 .addAnnotatedClass(Student.class)
				                 .buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			//start the transaction
			session.beginTransaction();
			
			//query the students
			List<Student> students = session.createQuery("from Student").list();
			
			//dispaly students
			displayStudents(students);
			
			//query with last name=Rathod
			students = session.createQuery("from Student s where s.lastName='Rathod'").list();
			
			//display students with last name=Rathod
			System.out.println("\n\nStudents with LastName=Rathod");
			displayStudents(students);
			
			//query students with lastName "Rathod" OR firstName "Akshay"
			students = session.createQuery("from Student s where "
					+ "s.lastName='Rathod' OR s.firstName='Akshay'").list();
			
			//display students with lastName "Rathod" OR firstName "Akshay"
			System.out.println("\n\nStudents lastName Rathod OR firstName Akshay");
			displayStudents(students);
			
			//query students where email LIKE '%gmail.com'
			students = session.createQuery("from Student s where "
					+ "s.email LIKE '%gmail.com'").list();
			
			//display students where email LIKE '%gmail.com'
			System.out.println("\n\nStudents where email LIKE '%gmail.com'");
			displayStudents(students);
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done successfully!");
			
		}
		finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> students) {
		for (Student theStudent : students) {
			System.out.println(theStudent);
		}
	}

}
