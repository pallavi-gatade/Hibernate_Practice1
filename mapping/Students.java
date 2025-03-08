package many.to.many.mapping;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Students {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String studName;

	@ManyToMany // (mappedBy = "students")
//	@JoinColumn(name = "student_id")
	@JoinTable(name = "students_departments", joinColumns = @JoinColumn(name = "departments_id"), inverseJoinColumns = @JoinColumn(name = "students_id"))
	private List<Departments> departments;

	public Students() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Students(int id, String studName, List<Departments> departments) {
		super();
		this.id = id;
		this.studName = studName;
		this.departments = departments;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStudName() {
		return studName;
	}

	public void setStudName(String studName) {
		this.studName = studName;
	}

	public List<Departments> getDepartments() {
		return departments;
	}

	public void setDepartments(List<Departments> departments) {
		this.departments = departments;
	}

	@Override
	public String toString() {
		return "Students [id=" + id + ", studName=" + studName + ", departments=" + departments + "]";
	}

}
