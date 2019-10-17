package com.mycompany.hibernate_demo_singletable.table_per_class;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Labor.class)
				.addAnnotatedClass(Regular.class).addAnnotatedClass(Contractor.class)
				.buildSessionFactory();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		Labor e1 = new Labor();
		e1.setName("John");
		e1.setPhone("9164253727");
		
		
		Regular e2 = new Regular();
		e2.setName("Shane");
		e2.setPhone("9535563151");
		e2.setSalary(50000);
		e2.setBonus(5);
		
		
		Contractor e3 = new Contractor();
		e3.setName("Sachin");
		e3.setPhone("8197929371");
		e3.setPay_per_hour(1000);
		e3.setContract_duration("15 hours");

		session.persist(e1);
		session.persist(e2);
		session.persist(e3);

		t.commit();
		session.close();
		System.out.println("success");
	}
}
