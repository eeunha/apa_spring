package com.project.apa.search;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.apa.api.search.model.HospitalInfoDTO;
import com.project.apa.api.search.service.SearchService;


@Controller
@RequestMapping("/search/reservation")
public class ReservationController {

	@Autowired
	private SearchService service;
	
	@PostMapping(value = "/select.do")
	public String select(Model model, String seq, String choicetype) {
		
		HospitalInfoDTO dto = service.hospitalInfo(seq);
		dto.setOpentime(dto.getOpentime().substring(11,16));
		dto.setClosetime(dto.getClosetime().substring(11,16));
		dto.setRestopentime(dto.getRestopentime().substring(11,16));
		dto.setRestclosetime(dto.getRestclosetime().substring(11,16));
		
		System.out.println(choicetype);
		
		model.addAttribute("dto", dto);
		model.addAttribute("deptlist", service.deptlist(seq));
		model.addAttribute("doclist", service.doclist(seq));
		model.addAttribute("choicetype", choicetype);
		
		
		
		return "search.reservation.select";
	}
	
	@PostMapping(value = "/detail.do")
	public String detail(Model model, String seq, String choicetype, String choicedoc, String choicedate, String choicetime) {

		System.out.println(seq);
		System.out.println(choicetype);
		System.out.println(choicedoc);
		System.out.println(choicedate);
		System.out.println(choicetime);
		
		return "search.reservation.detail";
	}
	
	

}
