package com.project.apa.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.apa.api.admin.domain.BlackDTO;
import com.project.apa.api.admin.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService service;
	
	@GetMapping(value = "/user.do")
	public String user(Model model) {
		model.addAttribute("userinfo", service.userInfo());
		
		return "admin.user";
	}
	
	@GetMapping(value = "/hospital.do")
	public String hospital(Model model) {
		model.addAttribute("hospitalinfo", service.hospitalInfo());
		
		return "admin.hospital";
	}
	
	@GetMapping(value = "/pharmacy.do")
	public String pharmacy(Model model) {
		model.addAttribute("pharmacyinfo", service.pharmacyInfo());
		
		return "admin.pharmacy";
	}
	
	@GetMapping(value = "/blacklist.do")
	public String blacklist(Model model) {
		
		model.addAttribute("blacklist", service.blacklist());
		
		return "admin.blacklist";
	}
	
	@GetMapping(value = "/blacklistadd.do")
	public String blacklistAdd(Model model) {
		
		return "admin.blacklistadd";
	}
	
}
