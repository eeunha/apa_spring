package com.project.apa.api.search;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.apa.mapper.SearchMapper;
import com.project.apa.search.HospitalInfoDTO;
import com.project.apa.search.SearchDAO;
import com.project.apa.search.SelfsymtomDTO;

@Controller
@RequestMapping("/search")
public class RestSearchController {
	
	@Autowired
	private SearchDAO dao;
	
	@PostMapping(value = "/tagfind.do")
	public List<HospitalInfoDTO> tagfind(Model model, String seq1, String seq2, String seq3, String seq4, String seq5, String seq6, String seq7, String seq8) {

		List<String> findsystomlist = dao.findsystomlist(seq1,seq2,seq3,seq4,seq5,seq6,seq7,seq8);

		System.out.println("여기는 옴");
		return dao.findHospitalList(findsystomlist);
	}
}
