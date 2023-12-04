package com.project.apa.hospital.test;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

	@GetMapping(value = "/index.do")
	public String index(Model model) {
		return "index";
	}

	@GetMapping(value = "/list.do")
	public String list(Model model) {
		return "list";
	}
}
