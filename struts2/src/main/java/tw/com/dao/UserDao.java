package tw.com.dao;

import tw.com.dto.UserRegisterRequest;
import tw.com.model.User;

public interface UserDao {
	
	User getUserByEmail(String userEmail);
	
	User getUserById(Integer userId);

	Integer createUser(UserRegisterRequest userRegisterRequest);
	
	void updatePassWord(User user);
}
