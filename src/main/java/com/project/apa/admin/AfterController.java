package com.project.apa.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.apa.api.admin.domain.AfterDTO;
import com.project.apa.api.admin.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AfterController {
	
	@Autowired
	private AdminService service;
	
	
	@GetMapping(value = "/afterlist.do")
	public String afterlist(Model model) {
		
		model.addAttribute("afterlist", service.afterlist());
		
		return "admin.afterlist";
	}
	
	@GetMapping(value = "/afterview.do")
	public String afterview(Model model, String hospitalId) {
		
		List<AfterDTO> afterview = service.afterview(hospitalId);
		model.addAttribute("afterview", afterview);
		
		return "admin.afterview";
	}
	 
}
