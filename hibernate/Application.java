package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Application {

	public static void main(String[] args) {

		SessionFactory factory = new HibernateUtil().getSessionFactory();

//    	System.out.println(factory);

		Session session = factory.openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();

			Student stud = new Student();
			Student stud1 = new Student();
			Student stud2 = new Student();
			Student stud3 = new Student();
			Student stud4 = new Student();
			
			stud.setName("Komal");
			stud.setEmail("komalshinde@gmail.com");
			stud.setAddress("PCMC");
			
			stud1.setName("Pooja Khaire");
			stud1.setEmail("poojakhaire@gmail.com");
			stud1.setAddress("Kothrud, Pune");
			
			stud2.setName("Shital Kumbhar");
			stud2.setEmail("shitalkumbhar@gmail.com");
			stud2.setAddress("Katraj, Pune");
			
			stud3.setName("Neha Patil");
			stud3.setEmail("nehapatil@gmail.com");
			stud3.setAddress("FC, Pune");
			
			stud4.setName("Neha Keskar");
			stud4.setEmail("keskarneha@gmail.com");
			stud4.setAddress("Kothrud, Pune");

			session.save(stud);
			session.save(stud1);
			session.save(stud2);
			session.save(stud3);
			session.save(stud4);
			
			transaction.commit();
			
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		}

		finally {
			session.close();
		}
	}
}
