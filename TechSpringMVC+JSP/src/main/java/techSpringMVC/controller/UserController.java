package techSpringMVC.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import techSpringMVC.dto.UserLoginRequest;
import techSpringMVC.dto.UserRegisterRequest;
import techSpringMVC.model.User;

import techSpringMVC.service.UserService;

@Controller
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/users/register")
	public String register(@Valid UserRegisterRequest userRegisterRequest, BindingResult result, Model model) {

		if (result.hasErrors()) {
			model.addAttribute("erroMsg", result.getAllErrors());
			return "regist";
		}

		Integer userId = userService.register(userRegisterRequest);

		if(userId==0) {
			String status = "exist";
			model.addAttribute("status", status);
			return "regist";
		}else {
			User user = userService.getUserById(userId);
			model.addAttribute("user", user);			
			return "regist";
		}
	}

	@PostMapping("/users/reset")
	public String forgetPassWord(@RequestParam String userAccount,@RequestParam String email) {

		userService.forgetPassWord(userAccount,email);

		return "reset";
	}

	@PostMapping("/users/login")
	public String login(@Valid UserLoginRequest userLoginRequest, Model model) {

		User user = userService.login(userLoginRequest);

		model.addAttribute("user", user);

		return "index";
	}

	@ResponseBody
	@PostMapping(value = "/users/check", produces = "text/plain;charset=UTF-8")
	public String checkEmail(String email) {

		return userService.checkEmail(email);
	}

	@RequestMapping("/")
	public String indexViews() {

		return "index";
	}

	@RequestMapping("/regist")
	public String registViews() {

		return "regist";
	}
	
	@RequestMapping("/reset")
	public String resetViews() {

		return "reset";
	}
}
