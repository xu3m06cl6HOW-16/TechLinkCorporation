package techSpringMVC.model;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable{
	
	private Integer userId;
	private String userName;
	private String userAccount;
	private String userPass;
	private String userEmail;
	private Date userCreateDate;
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	public User(Integer userId, String userName, String userAccount, String userPass, String userEmail,
			Date userCreateDate) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userAccount = userAccount;
		this.userPass = userPass;
		this.userEmail = userEmail;
		this.userCreateDate = userCreateDate;
	}


	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getUserAccount() {
		return userAccount;
	}


	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}


	public String getUserPass() {
		return userPass;
	}


	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}


	public String getUserEmail() {
		return userEmail;
	}


	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}


	public Date getUserCreateDate() {
		return userCreateDate;
	}


	public void setUserCreateDate(Date userCreateDate) {
		this.userCreateDate = userCreateDate;
	}


	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userAccount=" + userAccount + ", userPass="
				+ userPass + ", userEmail=" + userEmail + ", userCreateDate=" + userCreateDate + "]";
	}
	
	
	

}
