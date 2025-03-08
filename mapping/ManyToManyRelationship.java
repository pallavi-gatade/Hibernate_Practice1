package many.to.many.mapping;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManyToManyRelationship {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Students stud1 = new Students();
		stud1.setStudName("Megha");

		Students stud2 = new Students();
		stud2.setStudName("Sandhya");

		Departments dept1 = new Departments();
		dept1.setDeptName("CS");

		Departments dept2 = new Departments();
		dept2.setDeptName("IT");
		
		List<Students> studentList = new ArrayList<Students>();
		studentList.add(stud1);
		studentList.add(stud2);

		List<Departments> DepartmentList = new ArrayList<Departments>();
		DepartmentList.add(dept2);
		DepartmentList.add(dept1);
		
		stud1.setDepartments(DepartmentList);
		dept1.setStudents(studentList);

		Session session = factory.openSession();

		Transaction tx = session.beginTransaction();

		session.save(stud1);
		session.save(stud2);
		session.save(dept1);
		session.save(dept2);

		tx.commit();
		session.close();

		factory.close();
		


	}

}
