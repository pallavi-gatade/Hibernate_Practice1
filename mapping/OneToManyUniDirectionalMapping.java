package one.to.many.mapping;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;

import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class OneToManyUniDirectionalMapping {

	public static void main(String[] args) {

		Configuration cfg = new Configuration().configure();
		
		SessionFactory factory = cfg.buildSessionFactory();
		
		Department depart = new Department();
		depart.setDepartmentName("Science");

		Department depart1 = new Department();
		depart1.setDepartmentName("Commerce");

		Department depart2 = new Department();
		depart2.setDepartmentName("Arts");

		Department depart3 = new Department();
		depart3.setDepartmentName("Computer Science");

		Department depart4 = new Department();
		depart4.setDepartmentName("Maths");

		List<Department> departList = new ArrayList<Department>();
		departList.add(depart4);
		departList.add(depart2);
		departList.add(depart1);
		
		List<Department> departList1 = new ArrayList<Department>();
		departList1.add(depart);
		departList1.add(depart3);
		departList1.add(depart4);

		College clg = new College();
		clg.setName("Siddhivinayak");
		clg.setAddress("Karvenagar");
		clg.setDepartment(departList);
		
		College clg1 = new College();
		clg1.setName("Garware");
		clg1.setAddress("Deccan");
		clg1.setDepartment(departList1);

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		// create operation
//		session.save(clg);
//		session.save(clg1);

//		Get College details by Id
		College college = session.get(College.class, 1);
		System.out.println(college);
		System.out.println("----------------------------------------------");

//		fetch all the department list in the table
		List<Department> departments = session.createQuery("FROM Department", Department.class).list();
		System.out.println(departments);
		System.out.println("----------------------------------------------");

//		Fetch details of departments by given departments name 
		String hql = "FROM Department WHERE departmentName = : deptName";
		Query<Department> query = session.createQuery(hql, Department.class);
		query.setParameter("deptName", "Computer Science");

		List<Department> result = query.list();
		System.out.println(result);
		System.out.println("----------------------------------------------");

		HibernateCriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Department> cq = cb.createQuery(Department.class);
		Root<Department> root = cq.from(Department.class);
		cq.select(root).where(cb.equal(root.get("departmentName"), "Maths"));

		Query<Department> query1 = session.createQuery(cq);
		List<Department> departments1 = query.getResultList();
		System.out.println(departments1);
		System.out.println("----------------------------------------------");

//		find specific fields of the entities in a seperate DTO
		String jpql = "SELECT new one.to.many.mapping.DepartmentCollegeDTO(d., c.name) "
				+ "FROM Department d JOIN d.college c";

		List<DepartmentCollegeDTO> resultList = session.createQuery(jpql, DepartmentCollegeDTO.class).getResultList();

		tx.commit();
		

		factory.close();
		
	}

}
