package com.project.apa.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.apa.api.admin.domain.ReportDTO;
import com.project.apa.api.admin.service.AdminService;

@Controller
@RequestMapping("/admin")
public class ReportController {
	
	@Autowired
	private AdminService service;
	
	@GetMapping(value = "/reportlist.do")
	public String reportlist(Model model) {
		
		model.addAttribute("postreportlist", service.postreportlist());
		model.addAttribute("commentreportlist", service.commentreportlist());
		
		return "admin.reportlist";
	}
	
	@GetMapping(value = "/postreportview.do")
	public String postreportview(Model model, String communityWriter) {
		
		List<ReportDTO> postreportview = service.postreportview(communityWriter);
		model.addAttribute("postreportview", postreportview);
		
		return "admin.postreportview";
	}
	
	@GetMapping(value = "/commentreportview.do")
	public String commentreportview(Model model, String commentWriter) {
		
		List<ReportDTO> commentreportview = service.commentreportview(commentWriter);
		model.addAttribute("commentreportview", commentreportview);
		
		
		return "admin.commentreportview";
	}
	
}
