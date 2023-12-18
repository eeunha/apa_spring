package com.project.apa.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.apa.auth.service.AuthService;
import com.project.apa.mapper.AuthMapper;

@Controller
@RequestMapping("/auth")
public class AuthContoller {

	@Autowired
	private AuthMapper mapper;
	
	@Autowired
	private AuthService service;
	
	@Autowired
	private PasswordEncoder encoder;

	@GetMapping(value = "/accesserror.do")
	public String accesserror(Model model) {
		
		return "auth.accesserror";
	}
	
	@GetMapping(value = "/mylogin.do")
	public String mylogin(Model model) {

		return "auth.mylogin";
	}
	
	@GetMapping(value = "/mylogout.do")
	public String mylogout (Model model) {

		return "auth.mylogout";
	}
	
	@GetMapping(value = "/myinfo.do")
	public String myinfo(Model model) {

		return "auth.myinfo";
	}	
	
}
