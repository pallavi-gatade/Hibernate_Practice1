package one.to.many.mapping;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "college")
public class College {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "college_id")
	private int id;
	
	@Column(name = "college_name", length = 100)
	private String name;
	
	private String address;
	
	@OneToMany(mappedBy = "college", cascade = CascadeType.ALL)
	private List<Department> department = new ArrayList<Department>();


	public College() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void addDepartment(Department dept) {
		department.add(dept);
		dept.setCollege(this); // 🔥 This ensures the FK is set correctly
	}
	public College(int id, String name, String address, List<Department> department) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.department = department;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Department> getDepartment() {
		return department;
	}

	public void setDepartment(List<Department> department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "College [id=" + id + ", name=" + name + ", address=" + address + ", department=" + department + "]";
	}
	
}
