package com.hibernate;


import java.util.Properties;

import javax.imageio.spi.ServiceRegistry;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

public class HibernateUtil {

	private static SessionFactory sessionFactory;
	 
	public static SessionFactory getSessionFactory()
	{
		if(sessionFactory == null)
		{
		Configuration configuration = new Configuration();
		
		Properties properties = new Properties();
		
		properties.put(Environment.DRIVER, "org.postgresql.Driver");
		properties.put(Environment.URL, "jdbc:postgresql://localhost/myhibernate");
		properties.put(Environment.USER, "postgres");
		properties.put(Environment.PASS, "Pvgatade24");
		properties.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
		properties.put(Environment.HBM2DDL_AUTO, "update");
		properties.put(Environment.SHOW_SQL, true);
		
		configuration.setProperties(properties);
		
		StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		
		configuration.addAnnotatedClass(Student.class);
		
		sessionFactory = configuration.buildSessionFactory(serviceRegistry); 
		
		}
		return sessionFactory;
	}
	
}
