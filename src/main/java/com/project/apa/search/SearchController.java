package com.project.apa.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.apa.mapper.SearchMapper;


@Controller
@RequestMapping("/search")
public class SearchController {

	@Autowired
	private SearchMapper mapper;
	
	@GetMapping(value = "/list.do")
	public String list(Model model) {

		model.addAttribute("symtomlist", mapper.symtomlist());

		return "search.list";
	}
	
	@PostMapping(value = "/search/tagfind.do")
	public String tagfind(Model model) {

		return "search.list";
	}
}
