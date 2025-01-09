package com.struts2.model;

public class Employee {

	private Integer employeeId;
	private String firstName;
	private String lasttName;
	private String Email;

	public Employee() {
		super();
	}

	public Employee(Integer employeeId, String firstName, String lasttName, String email) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lasttName = lasttName;
		Email = email;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLasttName() {
		return lasttName;
	}

	public void setLasttName(String lasttName) {
		this.lasttName = lasttName;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", lasttName=" + lasttName
				+ ", Email=" + Email + "]";
	}
	
}