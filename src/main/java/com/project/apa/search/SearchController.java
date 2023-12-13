package com.project.apa.search;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.apa.api.search.model.HospitalInfoDTO;
import com.project.apa.api.search.model.ReviewDTO;
import com.project.apa.api.search.service.SearchService;


@Controller
@RequestMapping("/search")
public class SearchController {

	@Autowired
	private SearchService service;
	
	@GetMapping(value = "/list.do")
	public String list(Model model) {

		model.addAttribute("symtomlist", service.symtomlist());
		model.addAttribute("deptlist", service.deptlist());
		/* model.addAttribute("dto", service.basichospitalInfo()); */
		
		return "search.list";
	}
	
	@GetMapping(value = "/view.do")
	public String view(Model model, String seq) {
		
		int positive = 0;
		int negative = 0; 
		
		List<ReviewDTO> reviewtaglist = service.reviewtaglist(seq);
		
		for (ReviewDTO dto : reviewtaglist) {
			if (dto.getTagType().equals("긍정")) {
				positive++;
			} else {
				negative++;
			}
		}
		if (positive == 0 && negative == 0) {
			positive = 0;
		}else {
			positive = (positive*100/(positive+negative));			
		}
		HospitalInfoDTO hospitallist = service.hospitalInfo(seq);
		hospitallist.setOpentime(hospitallist.getOpentime().substring(11,16));
		hospitallist.setClosetime(hospitallist.getClosetime().substring(11,16));
		hospitallist.setRestopentime(hospitallist.getRestopentime().substring(11,16));
		hospitallist.setRestclosetime(hospitallist.getRestclosetime().substring(11,16));
		
		
		model.addAttribute("dto", hospitallist);
		model.addAttribute("deptlist", service.deptlist(seq));
		model.addAttribute("doclist", service.doclist(seq));
		model.addAttribute("reviewlist", service.reviewlist(seq));
		model.addAttribute("positive",positive);
		model.addAttribute("negative",negative);
		model.addAttribute("reviewtaglist", reviewtaglist);
		model.addAttribute("bookmarkcount", service.bookmarkcount(seq));
		
		
		
		return "search.view";
	}

}
