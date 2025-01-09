package com.struts2;

import com.struts2.dao.EmployeeDao;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;



public class UserAction implements RequestAware{
	
	private EmployeeDao empDao = new EmployeeDao();
	
	public String list() {
		request.put("emps", empDao.getEmployees());
		return "list";
	}

	private Map<String,Object> request;
	
	@Override
	public void setRequest(Map<String, Object> arg0) {
		this.request = arg0;
	}



}
