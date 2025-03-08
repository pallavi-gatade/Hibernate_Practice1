package one.to.one.mapping;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToOneBiDirectional {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		System.out.println(factory);
		
		factory.close();
	}

}
