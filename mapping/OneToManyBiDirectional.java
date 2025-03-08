package one.to.many.mapping;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneToManyBiDirectional {

	public static void main(String[] args) {

	Configuration cfg = new Configuration().configure();
	
	SessionFactory factory = cfg.buildSessionFactory();
	
	Department depart1 = new Department();
	depart1.setDepartmentName("Science");

	Department depart2 = new Department();
	depart2.setDepartmentName("Commerce");

	Department depart3 = new Department();
	depart3.setDepartmentName("Arts");

	Department depart4 = new Department();
	depart3.setDepartmentName("Computer Science");

	Department depart5 = new Department();
	depart5.setDepartmentName("Maths");

//	List<Department> departList = new ArrayList<Department>();
//	departList.add(depart4);
//	departList.add(depart2);
//	departList.add(depart1);
//
//	List<Department> departList1 = new ArrayList<Department>();
//	departList1.add(depart);
//	departList1.add(depart3);
//	departList1.add(depart4);

	College clg = new College();
	clg.setName("Siddhivinayak");
	clg.setAddress("Karvenagar");
//	clg.setDepartment(departList);
	clg.addDepartment(depart1);
	clg.addDepartment(depart2);
	clg.addDepartment(depart3);

	College clg1 = new College();
	clg1.setName("Garware");
	clg1.setAddress("Deccan");
//	clg1.setDepartment(departList1);
	clg1.addDepartment(depart4);
	clg1.addDepartment(depart5);

	// create operation

	Session session = factory.openSession();
	Transaction tx = session.beginTransaction();
	
//	session.save(clg);
//	session.save(clg1);
	
	Department dept = session.get(Department.class, 2);

	System.out.println("College Name : " + dept.getCollege().getName());
	System.out.println("department names : " + dept.getDepartmentName());

//	find Department list with perspective college name by using STRING_AGG() in native SQL
	String sql = "SELECT c.college_name, STRING_AGG(d.departmentname, ', ') FROM "
			+ "College c JOIN Department d ON c.college_id = d.college_id GROUP BY c.college_name";
	List<Object[]> resultList = session.createNativeQuery(sql).getResultList();
	
	for (Object[] row : resultList) {
		String collegeName = (String) row[0];
		String departmentNames = (String) row[1];

		System.out.println("College: " + collegeName + ", Departments: " + departmentNames);
	}

//	System.out.println(resultList.toString());

	tx.commit();
	session.close();

	factory.close();

	}
}
