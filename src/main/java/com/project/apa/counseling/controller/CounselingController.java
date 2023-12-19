package com.project.apa.counseling.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.apa.counseling.model.CounselingDTO;
import com.project.apa.counseling.model.DoctorDto;
import com.project.apa.counseling.repository.CounselingDAO;
import com.project.apa.mapper.CounselingMapper;

@Controller
@RequestMapping("/hospital/counseling")
public class CounselingController {

	@Autowired
	private CounselingMapper mapper;
	

	@Autowired
	private CounselingDAO dao;
	
	@GetMapping(value = "/list.do")
	public String waitingList(Model model) {
		

		
		return "hospital.counseling.list";
	}

	@GetMapping(value = "/doctors/{hospitalId}")
	@ResponseBody
	public ResponseEntity<List<DoctorDto>> getDoctors(@PathVariable String hospitalId) {
	    System.out.println("test");
		List<DoctorDto> doctorList = mapper.getDoctors(hospitalId);
	    return new ResponseEntity<>(doctorList, HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/waitingview.do")
	public String view(Model model, int mediCounselQuestionSeq, String doctorSeq) {
		
		CounselingDTO counselingdto = dao.get(mediCounselQuestionSeq);
		
		model.addAttribute("counselingdto", counselingdto);
		model.addAttribute("doctorSeq",doctorSeq);

		return "hospital.counseling.waitingview";
	}
	
	@PostMapping(value="/answeraddok.do")
	public String answeraddok(int mediCounselQuestionSeq, int doctorSeq, String counselAnswerContent) {
		CounselingDTO counselingdto = new CounselingDTO();
		counselingdto.setCounselAnswerContent(counselAnswerContent);
		counselingdto.setDoctorSeq(doctorSeq);
		counselingdto.setMediCounselQuestionSeq(mediCounselQuestionSeq);


		dao.answeradd(counselingdto);
		System.out.println("test");
		dao.answerupdate(counselingdto);
		System.out.println("test");
		
		
		
		return "redirect:/hospital/counseling/list.do";

	}
	
	@GetMapping(value = "/completeview.do")
	public String completeview(Model model, int mediCounselQuestionSeq, int doctorSeq, int mediCounselAnswerSeq) {
		
		CounselingDTO counselingdto = dao.getcomplete(mediCounselQuestionSeq);
	
		model.addAttribute("counselingdto", counselingdto);
		model.addAttribute("doctorSeq",doctorSeq);

		return "hospital.counseling.completeview";
	}	

}
