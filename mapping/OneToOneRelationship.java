package one.to.one.mapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class OneToOneRelationship {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		Session session = factory.openSession();
		
		VishwaWorldTravels travels = new VishwaWorldTravels();
		travels.setSeatNumber(101);
		travels.setBusNumber("MH25Z7476");
		
		VishwaWorldTravels travels1 = new VishwaWorldTravels();
		travels1.setSeatNumber(102);
		travels1.setBusNumber("MH12UK9705");
				
		VishwaWorldTravels travels2 = new VishwaWorldTravels();
		travels2.setSeatNumber(103);
		travels2.setBusNumber("MH12US7680");
		
		VishwaWorldTravels travels3 = new VishwaWorldTravels();
		travels3.setSeatNumber(100);
		travels3.setBusNumber("MH14AL5678");
		
		Passenger passenger = new Passenger();
		passenger.setName("Sachin");
		passenger.setEmail("sachin5555@gmail.com");
		passenger.setMobile("3221242342");
		passenger.setVishwaWorldTravels(travels1);
		
		Passenger passenger1 = new Passenger();
		passenger1.setName("Pallavi");
		passenger1.setEmail("pallavigatade@gmail.com");
		passenger1.setMobile("9809765434");
		passenger1.setVishwaWorldTravels(travels2);
		
		Passenger passenger2 = new Passenger();
		passenger2.setName("Karan");
		passenger2.setEmail("karanm7476@gmail.com");
		passenger2.setMobile("9011897654");
		passenger2.setVishwaWorldTravels(travels);
		
		Passenger passenger3 = new Passenger();
		passenger3.setName("Ajay");
		passenger3.setEmail("Ajay@gmail.com");
		passenger3.setMobile("8712637845");
		passenger3.setVishwaWorldTravels(travels3);
		
		Transaction tx = session.beginTransaction();
		
//		create data
		session.save(passenger);
		session.save(passenger1);
		session.save(passenger2);
		session.save(passenger3);
		System.out.println("Data Inserted Successfully........");
		
//		get data
		Passenger pass = session.get(Passenger.class, 2);
		System.out.print("Passenger Name is : " +  pass.getName());
		System.out.println(" and Seat number in travels is : " + pass.getVishwaWorldTravels().getSeatNumber());
		System.out.println("Data Fetched Successfully........");
		
		VishwaWorldTravels trav = session.get(VishwaWorldTravels.class, 3);
		String name = trav.getPassenger().getName();
		System.out.print("Traveller Name is:" + name);
		
//		update dada
		Passenger pass1 = session.get(Passenger.class, 2);
		pass1.setName("Neha Shah");
		pass1.setEmail("shahneha5555@gmail.com");
		pass1.setMobile("7890213456");
		pass1.setVishwaWorldTravels(travels);
		session.saveOrUpdate(pass1);
		System.out.println("Data Update Successfully........");
		
//		delete data
		Passenger pass2 = session.get(Passenger.class, 1);
		session.delete(pass2);
		System.out.println("Data Deleted Successfully........");
		
		tx.commit();
		session.close();
		factory.close();
	}

}
