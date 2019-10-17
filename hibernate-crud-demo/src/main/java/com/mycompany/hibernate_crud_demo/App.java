package com.mycompany.hibernate_crud_demo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mycompany.hibernate_crud_demo.model.Employee;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	try {
        	SessionFactory factory=
        			new Configuration().configure().
        			addAnnotatedClass(Employee.class).
        			buildSessionFactory();
        	Session session=
        			factory.getCurrentSession();
        	Employee employee=new Employee();
        	employee.setFirstName("John");
        	employee.setLastName("Doe");
        	employee.setEmail("john@email.com");
        	session.getTransaction().begin();
        	session.persist(employee);
        	session.getTransaction().commit();
        	System.out.println("sucess!");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    }
    }

