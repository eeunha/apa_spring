package com.project.apa.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.project.apa.api.user.service.UserService;


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
	
	@GetMapping(value = "/user/{seq}/mymeditest.do")
	public String mymeditest(@PathVariable String seq, Model model) {
		
		model.addAttribute("seq", seq);
		
		return "user.newtab.mymeditest";
	}
	
	@GetMapping(value = "/user/{seq}/mymediquestion.do")
	public String mymediquestion(@PathVariable String seq, Model model) {
		
		model.addAttribute("seq", seq);
		
		return "user.newtab.mymediquestion";
	}
	
	@GetMapping(value = "/user/{seq}/etcmediquestion.do")
	public String etcmediquestion(@PathVariable String seq, Model model) {
		
		model.addAttribute("seq", seq);
		
		return "user.newtab.etcmediquestion";
	}
	
	@GetMapping(value = "/user/{seq}/mycommunitydetail.do")
	public String mycommunitydetail(@PathVariable String seq, Model model) {
		
		model.addAttribute("seq", seq);
		
		return "user.newtab.mycommunitydetail";
	}
	
	@GetMapping(value = "/user/{seq}/myreview.do")
	public String myreview(@PathVariable String seq, Model model) {
		
		model.addAttribute("seq", seq);
		
		return "user.myreview";
	}
	
	@GetMapping(value = "/user/{seq}/myreviewdetail.do")
	public String myreviewdetail(@PathVariable String seq, Model model) {
		
		model.addAttribute("seq", seq);
		
		return "user.newtab.myreviewdetail";
	}
	
	@GetMapping(value = "/selftest/{seq}/list.do")
	public String selftestlist(@PathVariable String seq, Model model) {
		
		model.addAttribute("seq", seq);
		
		return "selftest.list";
	}
	
	@GetMapping(value = "/selftest/{tseq}/{seq}/test.do")
	public String selftest(@PathVariable String tseq, @PathVariable String seq, Model model) {
		
		model.addAttribute("tseq", tseq);
		model.addAttribute("seq", seq);
		
		return "selftest.test";
	}

	@GetMapping(value = "/selftest/{tseq}//test.do")
	public String selftest(@PathVariable String tseq, Model model) {
		
		model.addAttribute("tseq", tseq);
		
		return "selftest.test";
	}
	
	
}
