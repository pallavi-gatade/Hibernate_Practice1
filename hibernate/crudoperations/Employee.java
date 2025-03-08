package com.hibernate.crudoperations;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;

@Entity
@Table(name = "employee_details")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int empId;
	
	@Column(name = "empName", nullable = false, length = 30)
	private String empName;
	
	private double salary;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date joiningDate;
	
	private String empEmail;
	
	private boolean status;
	
	@Transient
	private String token;

	public Employee() {
		super();
	}

	public Employee(int empId, String empName, double salary, Date joiningDate, String empEmail, boolean status,
			String token) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.salary = salary;
		this.joiningDate = joiningDate;
		this.empEmail = empEmail;
		this.status = status;
		this.token = token;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Date getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", salary=" + salary + ", joiningDate="
				+ joiningDate + ", empEmail=" + empEmail + ", status=" + status + ", token=" + token + "]";
	}
}
