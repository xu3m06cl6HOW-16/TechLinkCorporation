package techSpringMVC.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.web.server.ResponseStatusException;

import techSpringMVC.dao.UserDao;
import techSpringMVC.dto.UserLoginRequest;
import techSpringMVC.dto.UserRegisterRequest;
import techSpringMVC.model.User;
import techSpringMVC.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	private final static Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	public Integer register(UserRegisterRequest userRegisterRequest) {
		
		User user = userDao.getUserByEmail(userRegisterRequest.getUserEmail());//檢查Email
		
		if(user != null) {
			log.warn("This email {} has already been registered.",user.getUserEmail());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}else {			
			String hashedPassword = DigestUtils.md5DigestAsHex(userRegisterRequest.getUserPass().getBytes());//加密
			userRegisterRequest.setUserPass(hashedPassword);
			return userDao.createUser(userRegisterRequest);
		}

	}

	@Override
	public User getUserById(Integer userId) {

		return userDao.getUserById(userId);
	}

	@Override
	public String forgetPassWord(String userAccount) {
		
		String userPass="123";
		userDao.updatePassWord(userAccount,userPass);
		
		return userPass;
	}

	@Override
	public User login(UserLoginRequest userLoginRequest) {
		
		User user = userDao.getUserByEmail(userLoginRequest.getEmail());
		String hashedPassword = DigestUtils.md5DigestAsHex(userLoginRequest.getPassWord().getBytes());
		if(user == null) {
			log.warn("This email {} has not been registered yet",userLoginRequest.getEmail());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		
		if(user.getUserPass().equals(hashedPassword) ) {
			return user;
		}else {
			log.warn("The password for this email {} is incorrect",userLoginRequest.getEmail());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		
	}

}
