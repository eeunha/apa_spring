package com.project.apa.search;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.apa.api.search.model.HospitalInfoDTO;
import com.project.apa.api.search.model.ReservationHospitalAppointmentDTO;
import com.project.apa.api.search.model.ReservationPharmacyAppointmentDTO;
import com.project.apa.api.search.model.UserInfoDTO;
import com.project.apa.api.search.service.SearchService;


@Controller
@RequestMapping(value = "/search/reservation")
public class ReservationController {

	@Autowired
	private SearchService service;
	
	@GetMapping(value = "/select.do")
	public String select(Model model, String seq, String choicetype) {
		
		HospitalInfoDTO dto = service.hospitalInfo(seq);
		dto.setOpentime(dto.getOpentime().substring(11,16));
		dto.setClosetime(dto.getClosetime().substring(11,16));
		dto.setRestopentime(dto.getRestopentime().substring(11,16));
		dto.setRestclosetime(dto.getRestclosetime().substring(11,16));
		
		model.addAttribute("dto", dto);
		model.addAttribute("deptlist", service.deptlist(seq));
		model.addAttribute("doclist", service.doclist(seq));
		model.addAttribute("choicetype", choicetype);
		
		
		
		return "search.reservation.select";
	}
	
	@GetMapping(value = "/detail.do")
	public String detail(Model model, String seq, String choicetype, String choicedoc, String choicedate, String choicetime, String userid) {

		String userseq = service.getuserseq(userid);
		
		UserInfoDTO userlist = service.userlist(userseq);
		
		
		model.addAttribute("firstssn", userlist.getUserssn().substring(0,6));
		model.addAttribute("lastssn", userlist.getUserssn().substring(7));
		model.addAttribute("firsttel", userlist.getUsertel().substring(0,3));
		model.addAttribute("middeltel", userlist.getUsertel().substring(4,8));
		model.addAttribute("lastltel", userlist.getUsertel().substring(9));
		
		model.addAttribute("hospitalid", seq);
		model.addAttribute("choicetype", choicetype);
		model.addAttribute("choicedoc", choicedoc);
		model.addAttribute("choicedate", choicedate);
		model.addAttribute("choicetime", choicetime);
		model.addAttribute("userlist", userlist);
		model.addAttribute("childlist", service.childlist(userseq));
		
		
		
		model.addAttribute("pharmacylist", service.pharmacylist());
		
		return "search.reservation.detail";
	}
	
	
	@GetMapping(value = "/complete.do")
	public String detail(ReservationHospitalAppointmentDTO rhadto, ReservationPharmacyAppointmentDTO rpadto,String username, String choicepharmacytime, Model model) {
		
		service.addHospitalAppintment(rhadto);
		service.addHospitalAppintmentStatus();
		
		if (rpadto.getPharmacyid() != "" && rpadto.getPharmacyid() != null) {
			rpadto.setRegdate(rhadto.getAppointmentdate().substring(0,11)+""+choicepharmacytime+":00");
			service.addPharmacyAppintment(rpadto);
			service.addPharmacyAppintmentStatus();
			
		}
		model.addAttribute("username",username);
		return "search.reservation.complete";
	}
	

}
