package techSpringMVC.dao;

import techSpringMVC.dto.UserRegisterRequest;
import techSpringMVC.model.User;

public interface UserDao {
	
	User getUserByEmail(String userEmail);
	
	User getUserById(Integer userId);

	Integer createUser(UserRegisterRequest userRegisterRequest);
	
	void updatePassWord(String userAccount,String userPass);
}
