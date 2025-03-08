package one.to.many.mapping;

import java.util.List;

public class DepartmentCollegeDTO {

	private List<String> departmentName;

	private String collegeName;

	public DepartmentCollegeDTO(List<String> departmentName, String collegeName) {
		super();
		this.departmentName = departmentName;
		this.collegeName = collegeName;
	}

	public List<String> getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(List<String> departmentName) {
		this.departmentName = departmentName;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	@Override
	public String toString() {
		return "DepartmentCollegeDTO [departmentName=" + departmentName + ", collegeName=" + collegeName + "]";
	}

}
