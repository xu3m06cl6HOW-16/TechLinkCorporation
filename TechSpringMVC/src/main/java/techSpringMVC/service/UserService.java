package techSpringMVC.service;

import techSpringMVC.dto.UserLoginRequest;
import techSpringMVC.dto.UserRegisterRequest;
import techSpringMVC.model.User;

public interface UserService {
	
	User login(UserLoginRequest userLoginRequest);
		
	User getUserById(Integer userId);
	
	Integer register(UserRegisterRequest userRegisterRequest);
	
	String forgetPassWord(String userAccount);
}
