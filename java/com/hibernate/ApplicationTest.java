package com.hibernate;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ApplicationTest {

//	@Test
//	public void testCreateOperation() {
//
//		boolean result = Application.saveStudentDetails();
//
//		Assertions.assertTrue(result);
//	}

	public SessionFactory sessionFactory;

	public Session session;

	public Transaction transaction;

	@BeforeEach
	void setUp() {

		sessionFactory = mock(SessionFactory.class);
		session = mock(Session.class);
		transaction = mock(Transaction.class);
		
	}

	@Test
	public void testSaveStudentDetails() {
		when(sessionFactory.openSession()).thenReturn(session);
		when(session.beginTransaction()).thenReturn(transaction);

		// create

		Student student = new Student();
		student.setName("Komal");
		student.setEmail("komalshinde@gmail.com");
		student.setAddress("PCMC");

		//when
		
		boolean result = Application.saveStudentDetails(student, sessionFactory);

		//then
		Assertions.assertTrue(result);
		verify(session).beginTransaction();
		verify(session).save(student);
		verify(transaction).commit();
		verify(session).close();

	}

}
