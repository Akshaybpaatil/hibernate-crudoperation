package com.practice.hibernate.demo.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {

	public static void main(String[] args) {

		// create a session factory
				SessionFactory factory = new Configuration()
						                 .configure("hibernate.cfg.xml")
						                 .addAnnotatedClass(Student.class)
						                 .buildSessionFactory();
				
				//create session
				Session session = factory.getCurrentSession();
				
				try {
					//create a 3 student objects
					System.out.println("Creating a 3 Student object...");
					
					Student student1 = new Student("Akash","Rathod","akashrathod.87@gmail.com");
					Student student2 = new Student("Srinivas","Rathod","srinivasrathod.68@gmail.com");
					Student student3 = new Student("Sachin","Mulge","sachinmulge.25@gmail.com");
					
					//start the transaction
					session.beginTransaction();
					
					//save the student object
					System.out.println("Saving the student....");
					session.save(student1);
					session.save(student2);
					session.save(student3);
					
					//commit transaction
					session.getTransaction().commit();
					
					System.out.println("Done!");
					
				}
				finally {
					factory.close();
				}
	}

}
