package com.project.apa.search;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.apa.api.search.model.HospitalInfoDTO;
import com.project.apa.api.search.model.PharmacyDTO;
import com.project.apa.api.search.model.ReviewDTO;
import com.project.apa.api.search.service.SearchService;


@Controller
@RequestMapping(value = "/search")
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
	@GetMapping(value = "/pharmacylist.do")
	public String pharmacylist(Model model) {
		Date nowtime = new Date();
		Date opentime = new Date();
		Date closetime = new Date();
		List<PharmacyDTO> list = service.pharmacylist();
		for (PharmacyDTO dto : list) {
			
			opentime.setHours(Integer.parseInt(dto.getOpentime().substring(0,2)));
			opentime.setMinutes(Integer.parseInt(dto.getOpentime().substring(3,5)));
			closetime.setHours(Integer.parseInt(dto.getClosetime().substring(0,2)));
			closetime.setMinutes(Integer.parseInt(dto.getClosetime().substring(3,5)));
			long timeopen = opentime.getTime();
			long timeclose = closetime.getTime();
			long timenow = nowtime.getTime();
			if (timeopen <= timenow && timeclose >= timenow) {
				dto.setOpentime("영업중");
			} else {
				dto.setOpentime("영업종료");
				
			}
			
		}
		model.addAttribute("list", list);
		
		return "search.pharmacylist";
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

	@GetMapping(value = "/pharmacyview.do")
	public String pharmacyview(Model model, String seq) {
		
		
		
		model.addAttribute("dto", service.pharmacyinfo(seq));
		
		return "search.pharmacyview";
	}
	
}
