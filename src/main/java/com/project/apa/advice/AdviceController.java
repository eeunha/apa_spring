package com.project.apa.advice;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdviceController {
	@GetMapping(value = "/advice/list.do")
	public String list(Model model) {

		return "advice.list";
	}
}
