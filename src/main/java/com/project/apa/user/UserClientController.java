package com.project.apa.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class UserClientController {

	@GetMapping(value = "/user/{seq}/mypage.do")
	public String mypage(@PathVariable String seq, Model model) {
		
		model.addAttribute("seq", seq);
		
		return "user.mypage";
	}
	
	@GetMapping(value = "/user/{seq}/mychild.do")
	public String mychild(@PathVariable String seq, Model model) {
		
		model.addAttribute("seq", seq);
		
		return "user.mychild";
	}

	@GetMapping(value = "/user/{seq}/mymedi.do")
	public String mymedi(@PathVariable String seq, Model model) {

		model.addAttribute("seq", seq);

		return "user.mymedi";
	}

	@GetMapping(value = "/user/{seq}/myrecord.do")
	public String myrecord(@PathVariable String seq, Model model) {
		
		model.addAttribute("seq", seq);
		
		return "user.newtab.myrecord";
	}
	
	@GetMapping(value = "/user/{seq}/insertreview.do")
	public String insertreview(@PathVariable String seq, Model model) {
		
		model.addAttribute("seq", seq);
		
		return "user.newtab.insertreview";
	}
	
	@GetMapping(value = "/user/{seq}/mybookmark.do")
	public String mybookmark(@PathVariable String seq, Model model) {
		
		model.addAttribute("seq", seq);
		
		return "user.mybookmark";
	}

	@GetMapping(value = "/user/{seq}/mybox.do")
	public String mybox(@PathVariable String seq, Model model) {
		
		model.addAttribute("seq", seq);
		
		return "user.mybox";
	}
	
	
}
