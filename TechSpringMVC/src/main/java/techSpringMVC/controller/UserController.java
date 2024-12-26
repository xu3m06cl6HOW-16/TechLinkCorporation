package techSpringMVC.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import techSpringMVC.dto.UserLoginRequest;
import techSpringMVC.dto.UserRegisterRequest;
import techSpringMVC.model.User;

import techSpringMVC.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/users/register")
	public ResponseEntity<User> register(@RequestBody @Valid UserRegisterRequest userRegisterRequest){
		
		Integer userId = userService.register(userRegisterRequest);
		
		User user = userService.getUserById(userId);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(user);
	}
	
	@PutMapping("/users/{userAccount}/reset")
	public ResponseEntity<String> forgetPassWord(@PathVariable String userAccount) {
		
		String newPass = userService.forgetPassWord(userAccount);
		
		return ResponseEntity.status(HttpStatus.OK).body(newPass);
	}
	
	@PostMapping("/users/login")
	public ResponseEntity<User> login(@RequestBody @Valid UserLoginRequest userLoginRequest){
		
		User user = userService.login(userLoginRequest);
		
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}
	

}
