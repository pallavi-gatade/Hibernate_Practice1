package com.hibernate.crudoperations;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class CreateApp {

	public static void main(String[] args) {

		Configuration configuration = new Configuration().configure();

		SessionFactory factory = configuration.buildSessionFactory();

		System.out.println(factory);
		
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		Employee emp_dls = new Employee();
		emp_dls.setEmpName("Megha Biradar");
		emp_dls.setSalary(205000.0);
		emp_dls.setJoiningDate(new Date());
		emp_dls.setEmpEmail("meghabiradar201@gmail.com");
		emp_dls.setStatus(true);
		
		Employee emp_dls1 = new Employee();
		emp_dls1.setEmpName("Sandhya Jagtap");
		emp_dls1.setSalary(310000.0);
		emp_dls1.setJoiningDate(new Date());
		emp_dls1.setEmpEmail("sandhyjagtap@gmail.com");
		emp_dls1.setStatus(false);
		
		Employee emp_dls2 = new Employee();
		emp_dls2 = new Employee();
		emp_dls2.setEmpName("Anjali Wangje");
		emp_dls2.setSalary(210000.0);
		emp_dls2.setJoiningDate(new Date());
		emp_dls2.setEmpEmail("anjaliw@gmail.com");
		emp_dls2.setStatus(true);
		
//		create operation
//		save Employee - create
		session.save(emp_dls);
		session.save(emp_dls1);
		session.save(emp_dls2);
		
		transaction.commit();
		session.close();
		
	}
}
