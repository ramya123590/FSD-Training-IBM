
package com.mycompany.hibernate_demo1.dao;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.modelmapper.ModelMapper;


import com.mycompany.hibernate_demo1.factory.MyHibernateFactory;
import com.mycompany.hibernate_demo1.model.Employee;
import com.mycompany.hibernate_demo1.shared.SharedEmployee;




public class EmployeeDAOImpl implements EmployeeDAO {
	
	private static Scanner scanner=new Scanner(System.in);
   
	private SessionFactory sessionFactory = null;
	private Session session = null;
	
	public EmployeeDAOImpl() {
		super();

		sessionFactory = MyHibernateFactory.getMySession();
	}

	@Override
	public void createEmployee(SharedEmployee sEmployee) {
		// TODO Auto-generated method stub
		
		ModelMapper mapper=new ModelMapper();
		Employee employee=mapper.map(sEmployee, Employee.class);
		UUID uUid=UUID.randomUUID();
		employee.setGeneratedId(uUid.toString());
		session.getTransaction().begin();
		session.save(employee);
		session.getTransaction().commit();

	}
	@Override
	public List<SharedEmployee> getAllEmployee() {
		// TODO Auto-generated method stub
		ModelMapper mapper=new ModelMapper();
		session.getTransaction().begin();
		Query query=session.createQuery("from Employee");
		session.getTransaction().commit();
		@SuppressWarnings("unchecked")
		List<Employee> list1=query.getResultList();
		List<SharedEmployee> sList=new ArrayList<SharedEmployee>();
		for(Employee e:list1)
		{
			SharedEmployee se=mapper.map(e, SharedEmployee.class);
			sList.add(se);
		}
		
		return sList;
	}
	@Override
	public SharedEmployee findById(int id) {
		// TODO Auto-generated method stub
		session = sessionFactory.openSession();
		session.getTransaction().begin();
		Employee employee = session.get(Employee.class, new Integer(id));
		session.getTransaction().commit();
		SharedEmployee sEmployee = null;
		if (employee != null) {
			ModelMapper mapper = new ModelMapper();
			sEmployee = mapper.map(employee, SharedEmployee.class);
			return sEmployee;
		} else {
			return null;
		}

	}
	@Override
	public void findByCustomId(String customId) {
		// TODO Auto-generated method stub

		session = sessionFactory.openSession();
		session.getTransaction().begin();
		Query query = session.createQuery("from Employee e where e.generatedId=:cId").setParameter("cId", customId);
		@SuppressWarnings("unchecked")
		List<Employee> l = query.getResultList();

		session.getTransaction().commit();
		ModelMapper mapper = new ModelMapper();
		List<SharedEmployee> sList = new ArrayList<SharedEmployee>();
		for (Employee e : l) {
			SharedEmployee se = mapper.map(e, SharedEmployee.class);
			sList.add(se);
		}

		if (!sList.isEmpty()) {
			for (SharedEmployee se : sList) {
				System.out.println(se);
			}
		} else {
			System.out.println("no such custom id found.");
		}

	}

	@Override
	public void deleteEmployee(int id) {
		// TODO Auto-generated method stub
		
		session=sessionFactory.openSession();
		session.getTransaction().begin();
		Employee e=session.get(Employee.class, id);
		if(e!=null)
		{
			session.delete(e);
			System.out.println("deleted sucessfully..");
			session.getTransaction().commit();
		}
		
		else
		{
			System.out.println("no such record found.");
		}
		
	}
	@Override
	public void updateEmployee(int id) {
		// TODO Auto-generated method stub
		
		session=sessionFactory.openSession();
		session.getTransaction().begin();
		Employee e=session.get(Employee.class, id);
		if(e!=null)
		{
			System.out.println("first name");
			String FName=scanner.next();
			e.setFirstName(FName);
			System.out.println("last name");
			String LName=scanner.next();
			e.setLastName(LName);
			System.out.println("email");
			String Email=scanner.next();
			e.setEmail(Email);
			session.update(e);
			System.out.println(" sucessfully..");
			session.getTransaction().commit();
		}
		
		else
		{
			System.out.println("no such record found.");
		}
		
	}
}