package com.struts2_3.demo;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport{
	
	public String save() {
		System.out.println("save");
		return "save-success";
	}
	public String update() {
		System.out.println("update");

		return "update-success";
	}
	public String delete() {
		System.out.println("delete");

		return "delete-success";
	}
	public String query() {
		System.out.println("query");
		return "query-success";
	}
	public String index() {
		return "success";
	}
	
}
