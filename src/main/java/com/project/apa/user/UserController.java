package com.project.apa.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.project.apa.mapper.UserMapper;
import com.project.apa.user.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserMapper mapper;
	
	@Autowired
	private UserService service;
	
	@GetMapping(value = "/user/mypage.do")
	public String main(String seq, Model model) {

		seq = "1";
		
		//model.addAttribute("seq", seq);
		
		UserDTO dto = service.getUser(seq);
		
		return "user.mypage";
	}
	
}
