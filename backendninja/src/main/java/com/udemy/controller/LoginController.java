package com.udemy.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.udemy.entity.User;
import com.udemy.entity.UserRole;
import com.udemy.repository.UserRepository;
import com.udemy.repository.UserRoleRepository;
import com.udemy.util.ViewConstant;

@Controller
public class LoginController {

	public static final Log LOG = LogFactory.getLog(LoginController.class);
	
	private static int count = 0;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserRoleRepository userRoleRepository;
	
	// @GetMapping("/")
	// public String redirectToLogin() {
	// LOG.info("METHOD: redirectToLogin()");
	// return "redirect:/" + ViewConstant.LOGIN;
	// }

	@GetMapping("/login")
	public String showLoginForm(Model model, @RequestParam(name = "error", required = false) String error, @RequestParam(name = "logout", required = false) String logout) {
		this.add();
		LOG.info("METHOD " + "showLoginForm() -- PARAMS: error=" + error + ", logout=" +logout);
		model.addAttribute("error", error);
		model.addAttribute("logout", logout);
		//model.addAttribute("userCredentials", new UserCredential());
		return ViewConstant.LOGIN;
	}

//	@PostMapping
//	public String loginCheck(@ModelAttribute(name = "userCredentials") UserCredential userCredential){
//		LOG.info("METHOD: " + "showLoginForm() -- PARAMS:" + userCredential);
//		
//		if(userCredential.getUsername().equals("user") && userCredential.getPassword().equals("user")){			
//			LOG.info("RETURNING TO CONTACTS VIEW");
//			return "redirect:/" + ViewConstant.CONTACTS + "/";
//		}
//		return "redirect:/" + ViewConstant.LOGIN + "?error";
//	}
	
	@GetMapping({"/loginsuccess", "/"})
	public String loginCheck(){
		LOG.info("METHOD: " + "loginCheck()");
		LOG.info("RETURNING TO CONTACTS VIEW");
		return "redirect:/" + ViewConstant.CONTACTS + "/";
		
		//return "redirect:/" + ViewConstant.LOGIN + "?error";
	}
	
	private void add(){
		if(count == 0){
			User user = new User("user",this.encode("user"), true, null);
			user = userRepository.save(user);
			UserRole role = new UserRole(user, "ROLE_USER");
			userRoleRepository.save(role);
		}
		this.userRepository.findAll();
		count++;
	}
	
	private String encode(String password){
		BCryptPasswordEncoder b = new BCryptPasswordEncoder();
		return b.encode(password);
	}
}
