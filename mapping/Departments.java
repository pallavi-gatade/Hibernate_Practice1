package many.to.many.mapping;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Departments {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String deptName;

	@ManyToMany(mappedBy = "departments")
	private List<Students> students;

	public Departments() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Departments(int id, String deptName, List<Students> students) {
		super();
		this.id = id;
		this.deptName = deptName;
		this.students = students;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public List<Students> getStudents() {
		return students;
	}

	public void setStudents(List<Students> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Departments [id=" + id + ", deptName=" + deptName + ", students=" + students + "]";
	}

}
