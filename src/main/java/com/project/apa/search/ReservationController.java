package com.project.apa.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.apa.api.search.service.SearchService;


@Controller
@RequestMapping("/search/reservation")
public class ReservationController {

	@Autowired
	private SearchService service;
	
	@GetMapping(value = "/select.do")
	public String select(Model model, String seq) {
		
		model.addAttribute("dto", service.hospitalInfo(seq));
		
		return "search.reservation.select";
	}

}
