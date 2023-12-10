package com.project.apa.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.apa.api.search.service.SearchService;


@Controller
@RequestMapping("/search/reservation")
public class ReservationController {

	@Autowired
	private SearchService service;
	
	@PostMapping(value = "/select.do")
	public String select(Model model, String seq, String choicetype) {
		System.out.println(choicetype);
		
		model.addAttribute("dto", service.hospitalInfo(seq));
		model.addAttribute("deptlist", service.deptlist(seq));
		model.addAttribute("doclist", service.doclist(seq));
		
		
		
		return "search.reservation.select";
	}

}
