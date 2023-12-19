package com.project.apa.counseling.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.apa.counseling.model.CounselingDTO;
import com.project.apa.counseling.model.DoctorDto;
import com.project.apa.counseling.repository.CounselingDAO;
import com.project.apa.mapper.CounselingMapper;

@RestController
@RequestMapping("/hospital/counseling")
public class RestCounselingController {
	
	@Autowired
	private CounselingDAO dao;
	
	@Autowired
	private CounselingMapper mapper;
	
	
	
	@PostMapping(value = "/counselingwaitinglist")
	public List<CounselingDTO> counselingwaitinglist(@RequestBody DoctorDto dto) {
		
		List<CounselingDTO> list = mapper.counselingwaitinglist(dto);
		for (CounselingDTO cdto : list) {
			cdto.setRegdate(cdto.getRegdate().substring(0,10));
			
		}
		
		return list;
	}

	@PostMapping(value = "/counselingcompletelist")
	public List<CounselingDTO> counselingcompletelist(@RequestBody DoctorDto dto) {
		
		List<CounselingDTO> list = mapper.counselingwaitinglist(dto);
		for (CounselingDTO cdto : list) {
			cdto.setRegdate(cdto.getRegdate().substring(0,10));
			
		}
		
		return list;
	}


	
}
