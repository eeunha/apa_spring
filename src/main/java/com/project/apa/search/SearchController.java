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
	private SearchDAO searchDAO;
	
	@GetMapping(value = "/list.do")
	public String list(Model model) {

		model.addAttribute("symtomlist", searchDAO.symtomlist());

		return "search.list";
	}

}
