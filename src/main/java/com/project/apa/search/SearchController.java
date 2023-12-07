package com.project.apa.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.apa.api.search.service.SearchService;


@Controller
@RequestMapping("/search")
public class SearchController {

	@Autowired
	private SearchService service;
	
	@GetMapping(value = "/list.do")
	public String list(Model model) {

		model.addAttribute("symtomlist", service.symtomlist());

		return "search.list";
	}
	
	@GetMapping(value = "/view.do")
	public String view(Model model, String seq) {
		
		model.addAttribute("dto", service.hospitalInfo(seq));
		model.addAttribute("deptlist", service.deptlist(seq));
		model.addAttribute("doclist", service.doclist(seq));
		model.addAttribute("reviewlist", service.reviewlist(seq));
		model.addAttribute("reviewtaglist", service.reviewtaglist(seq));
		
		return "search.view";
	}

}
