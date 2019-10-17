package com.mycompany.hibernate_demo_singletable.mode;


import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PersonTest {
	public static void main(String[] args) {
		try {
			SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Person.class)
					.addAnnotatedClass(Employee.class)
					.addAnnotatedClass(Account.class).buildSessionFactory();
			Session session = factory.openSession();
			Person p = new Person("ramya1","9164253727",new Date());
			Employee e = new Employee("ramya2","9164253727",new Date(),"Engineer","bangalore");
			Account a = new Account("ramya3","9164253727",new Date(), "canara");
		session.getTransaction().begin();
			session.save(p);
			session.save(e);
			session.save(a);
			session.getTransaction().commit();
			System.out.println("ok..");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}