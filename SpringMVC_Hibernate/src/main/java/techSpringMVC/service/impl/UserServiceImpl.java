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
import techSpringMVC.util.MailService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	private final static Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	public Integer register(UserRegisterRequest userRegisterRequest) {
		
		User user = userDao.getUserByEmail(userRegisterRequest.getUserEmail());//檢查Email
		
		if(user != null) {
			return 0;
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
	public String forgetPassWord(String userAccount,String email) {
		
		
		//發送密碼
		String subject = "密碼通知";//主旨

		String ch_name = userAccount;
		String passRandom = "111";
		String messageText = "Hello! " + ch_name + " 請謹記此密碼: " + passRandom + "\n" + " (已經啟用)";

		MailService mailService = new MailService();
		mailService.sendMail(email, subject, messageText);
		
		//更改密碼
		
		String hashedPassword = DigestUtils.md5DigestAsHex(passRandom.getBytes());
		
		User user = userDao.getUserByEmail(email);
		user.setUserPass(hashedPassword);
		userDao.updatePassWord(user);
		
		return passRandom;
	}

	@Override
	public User login(UserLoginRequest userLoginRequest) {
		
		User user = userDao.getUserByEmail(userLoginRequest.getEmail());
		String hashedPassword = DigestUtils.md5DigestAsHex(userLoginRequest.getPassWord().getBytes());
		if(user == null) {
			log.warn("This email {} has not been registered yet",userLoginRequest.getEmail());
			return null;
		}
		
		if(user.getUserPass().equals(hashedPassword) ) {
			return user;
		}else {
			log.warn("The password for this email {} is incorrect",userLoginRequest.getEmail());
			return null;
		}
		
	}

	@Override
	public String checkEmail(String email) {
		
		User user = userDao.getUserByEmail(email);
		String status;
		if(user == null) {
			status = "此Email可以使用";
			return status;
		}else{
			status = "此Email已經有人使用";
			return status;			
		}
		
	}

}
