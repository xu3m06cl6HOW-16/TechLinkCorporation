package tw.com.action;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

import tw.com.dto.UserLoginRequest;
import tw.com.dto.UserRegisterRequest;
import tw.com.service.UserService;


public class MyAction extends ActionSupport implements RequestAware,ServletResponseAware{
	
		@Autowired
		private UserService userService;
		
		@Autowired
		UserLoginRequest userLoginRequest;
		
		@Autowired
		UserRegisterRequest userRegisterRequest;
		
		private HttpServletResponse response;
		private String userName;
		private String userAccount;
		private String userEmail;
		private String userPass;
		
		@Action(value = "user-check")
	    public String check() throws IOException {
			String result = userService.checkEmail(userEmail);
			
			if (result.equals("此Email可以使用")) {
		        result = "<span style='color: green;'>" + result + "</span>";
		    } else {
		        result = "<span style='color: red;'>" + result + "</span>";
		    }
			
			response.setContentType("text/plain;charset=UTF-8");
		    response.getWriter().write(result);

	        return null;
	    }
		
		@Action(value = "user-reset",results = {@Result(name = "success", location= "/index.jsp")})
		public String forgetPass() {
			userService.forgetPassWord(userAccount, userEmail);
			return "success";
		}
		
		
		@Action(value = "emp-list", results = {@Result(name = "success", location = "/user.jsp")})
	    public String execute() {
	        
			userLoginRequest.setEmail(userEmail);
			userLoginRequest.setPassWord(userPass);
	        request.put("user", userService.login(userLoginRequest));
	        return "success";
	    }
		
		@Action(value = "user-add", results = {@Result(name = "success", location = "/index.jsp"),@Result(name = "input", location = "/index.jsp")})
	    public String register() {
			
			if (userEmail == null || !userEmail.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
		        addFieldError("userEmail", "Invalid email format.");
		        return "input";
		    }
			
			if("此Email已經有人使用".equals(userService.checkEmail(userEmail))) {
				addFieldError("userEmail", "This mailbox has already been registered");
		        return "input";
			}
	        
			userRegisterRequest.setUserName(userName);
			userRegisterRequest.setUserAccount(userAccount);
			userRegisterRequest.setUserPass(userPass);
			userRegisterRequest.setUserEmail(userEmail);
			Integer userId = userService.register(userRegisterRequest);
			
	        request.put("user", userService.getUserById(userId));
	        return "success";
	    }

		private Map<String,Object> request;

		@Override
		public void setRequest(Map<String, Object> arg0) {
			this.request = arg0;
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

		public String getUserEmail() {
			return userEmail;
		}

		public void setUserEmail(String userEmail) {
			this.userEmail = userEmail;
		}

		public String getUserPass() {
			return userPass;
		}

		public void setUserPass(String userPass) {
			this.userPass = userPass;
		}


		@Override
		public void setServletResponse(HttpServletResponse response) {
			this.response = response;
			
		}


}
