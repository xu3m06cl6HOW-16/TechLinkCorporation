package com.struts2.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.struts2.model.Employee;

public class EmployeeDao {
	
	private static Map<Integer,Employee> emps = new HashMap<Integer, Employee>();
	
	static {
		emps.put(1001, new Employee(1001,"AA","aa","aa@gmail.com"));
		emps.put(1002, new Employee(1002,"BB","bb","bb@gmail.com"));
		emps.put(1003, new Employee(1003,"CC","cc","cc@gmail.com"));
		emps.put(1004, new Employee(1004,"DD","dd","dd@gmail.com"));
		emps.put(1005, new Employee(1005,"EE","ee","ee@gmail.com"));
		
	}
	
	public List<Employee> getEmployees(){
		return new ArrayList<Employee>(emps.values());
	}

}