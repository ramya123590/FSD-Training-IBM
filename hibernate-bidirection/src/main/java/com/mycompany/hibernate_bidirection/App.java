package com.mycompany.hibernate_bidirection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mycompany.hibernate_bidirection.model.Instructor;
import com.mycompany.hibernate_bidirection.model.Instructor_details;


public class App 
{
	public static void main( String[] args )
    {
		/*
		
		try {
    	  SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").
   			   addAnnotatedClass(Instructor.class). addAnnotatedClass(Instructor_details.class).buildSessionFactory();
    	  
   	   Session session=factory.openSession();
   	  Instructor_details i = new Instructor_details();
   	 
   	 
     i.setHobby("sports");
     i.setYoutube("www.youtube.com");
   	 session.getTransaction().begin();
    
     session.persist(i);
     session.getTransaction().commit();
   	   
   	   
      
        Instructor c = new Instructor();
        c.setFirstName("ramya");
        c.setLastName("suvarna");
        c.setEmail("ram@gmail.com");
        c.setId_1(i);
      
        session.getTransaction().begin();
        session.persist(c);
     
        session.getTransaction().commit();
        session.close();
		}
		catch(Exception e) {
			
		}*/
    }
}