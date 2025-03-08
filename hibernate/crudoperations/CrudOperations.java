package com.hibernate.crudoperations;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CrudOperations {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
//		get operations (Read Data)
		Employee emp = session.get(Employee.class, 1);
		
		Employee emp1 = session.load(Employee.class, 2);  
		System.out.println(emp);
		System.out.println("Get Employee by given Id..........");
		
		List<Employee> employeeList = session.createQuery("from Employee", Employee.class).list();
		
		employeeList.forEach(e -> System.out.println(e));
		System.out.println("List of Employees..........");
		
//		update data
		Employee emp_dls = session.get(Employee.class, 5);
		emp_dls.setEmpName("Pragati Satpute");
		emp_dls.setSalary(2200000.0);
		emp_dls.setJoiningDate(new Date());
		emp_dls.setEmpEmail("pragatisatpute@gmail.com");
		emp_dls.setStatus(true);
		
		session.saveOrUpdate(emp_dls);
		System.out.println("Data update successfully.............");
	
//		delete data
		Employee employee = session.get(Employee.class, 4);
		session.delete(employee);
		System.out.println("Data delete successfully.............");
		
		transaction.commit();
		session.close();
		factory.close();
		
	}
}
