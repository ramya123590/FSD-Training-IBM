package com.mycompany.view;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customer_servlet_example.model.Customer;



public class ListAddCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
private List<Customer> list=null;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		list=new ArrayList<Customer>();
		list.add(new Customer("Autumn",20191,"Normal"));
		list.add(new Customer("Summer", 20192, "Corporate"));
		list.add(new Customer("Winter", 20193, "Normal"));
		out.println("<html><title>List All Available Customer</title><body><table border='1'><tr><td>nmae</td><td>id</td><td>type</td></tr>");
		
		for(Customer l:list)
		{
			out.println("<tr><td>"+l.getName()+"</td><td>"+l.getId()+"</td><td>"+l.getType()+"</td></tr>");
		}
		out.println("</table><a href='index.html'>Go To Home Page</a></body></html>");
		
	}

	
}