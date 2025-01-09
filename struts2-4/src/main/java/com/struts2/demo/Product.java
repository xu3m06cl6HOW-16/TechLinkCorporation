 package com.struts2.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;

public class Product implements RequestAware, SessionAware{
	
	private Integer productId;
	private String productName;
	private String productDesc;
	private Double productPrice;
	
	private List<Person> persons = new ArrayList<Person>();
	
	
	
	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(Integer productId, String productName, String productDesc, Double productPrice) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productDesc = productDesc;
		this.productPrice = productPrice;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public Double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productDesc=" + productDesc
				+ ", productPrice=" + productPrice + "]";
	}
	
	public String save() {
		System.out.println("save:" + this);
		//1.獲取值站
		ValueStack valueStack = ActionContext.getContext().getValueStack();
		//2.創建Test對象，並為其屬性賦值
		Test test = new Test();
		test.setProductDesc("goodComputer");
		test.setProductName("ThinkPad");
		
		//3.把Test對象押入到值站的站頂
		valueStack.push(test);
		
		sessionMap.put("product",this);
		requestMap.put("test",test);
		
		return "success";
	}
	
	public String testTag() {
		this.productId = 1001;
		this.productDesc = "intel";
		this.productName = "CPU";
		this.productPrice = 1000.0;
		
		persons.add(new Person("CC",30));
		persons.add(new Person("AA",10));
		persons.add(new Person("DD",40));
		persons.add(new Person("BB",20));
		
		return "success";
	}
	
	private Map<String,Object> sessionMap;

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.sessionMap = arg0;
	}
	
	private Map<String,Object> requestMap;

	@Override
	public void setRequest(Map<String, Object> arg0) {
		this.requestMap = arg0;
	}
	
}
