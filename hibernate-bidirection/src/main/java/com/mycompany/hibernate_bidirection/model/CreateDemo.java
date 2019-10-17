package com.mycompany.hibernate_bidirection.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(Instructor_details.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			Instructor tempInstructor = new Instructor("Madhu", "Patel", "madhu@luv2code.com");

			Instructor_details tempInstructorDetail = new Instructor_details("http://www.youtube.com", "Guitar");

			tempInstructor.setInstructorDetail(tempInstructorDetail);

			session.beginTransaction();

			System.out.println("Saving instructor: " + tempInstructor);
			session.save(tempInstructor);

			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}

}