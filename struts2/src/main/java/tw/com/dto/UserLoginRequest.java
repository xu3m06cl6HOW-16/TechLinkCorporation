package tw.com.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.springframework.stereotype.Component;

@Component
public class UserLoginRequest {
	
	@NotBlank
	@Email
	private String email;
	
	@NotBlank
	private String passWord;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	@Override
	public String toString() {
		return "UserLoginRequest [email=" + email + ", passWord=" + passWord + "]";
	}
	
	
	

}
