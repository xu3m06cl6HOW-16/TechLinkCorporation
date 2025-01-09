package com.struts2.demo;

import com.opensymphony.xwork2.ActionContext;

public class UserAction {

	private String userId;
	private String userName;
	private String password;
	private String desc;
	
	public UserAction() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserAction(String userId, String userName, String password, String desc) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.desc = desc;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	@Override
	public String toString() {
		return "UserAction [userId=" + userId + ", userName=" + userName + ", password=" + password + ", desc=" + desc
				+ "]";
	}
	
	public String save() {
		
		System.out.println(this);
		UserAction ua = new UserAction();
		ua.setUserId("1001");
		ua.setUserName("ATGUIGU");
		ua.setPassword("123456");
		ua.setDesc("Oracle");
		
		ActionContext.getContext().getValueStack().push(ua);
		return "input";
	}
	
	
}
