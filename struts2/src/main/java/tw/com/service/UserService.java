package tw.com.service;

import tw.com.dto.UserLoginRequest;
import tw.com.dto.UserRegisterRequest;
import tw.com.model.User;

public interface UserService {
	
	User login(UserLoginRequest userLoginRequest);
		
	User getUserById(Integer userId);
	
	Integer register(UserRegisterRequest userRegisterRequest);
	
	String forgetPassWord(String userAccount,String email);
	
	String checkEmail(String email);
}
