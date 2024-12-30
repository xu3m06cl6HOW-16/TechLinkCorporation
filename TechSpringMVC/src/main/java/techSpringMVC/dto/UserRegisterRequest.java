package techSpringMVC.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class UserRegisterRequest {
	
	@NotBlank
	private String userName;
	
	@NotBlank
	private String userAccount;

	@NotBlank
	private String userPass;

	@NotBlank
	@Email
	private String userEmail;
	
	
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
	
	
	

}
