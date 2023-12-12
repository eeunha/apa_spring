package com.project.apa.api.search;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.apa.api.search.model.ChildInfoDTO;
import com.project.apa.api.search.model.HospitalDoctorDTO;
import com.project.apa.api.search.service.SearchService;

@RestController
@RequestMapping("/search/reservation")
public class RestReservationController {
	
	@Autowired
	private SearchService service;
	
	@PostMapping(value = "/finddoc")
	public List<HospitalDoctorDTO> finddoc(@RequestBody HospitalDoctorDTO dto) {
		
		List<HospitalDoctorDTO> list = service.finddeptdoc(dto);
		
		return list;
	}
	
	@PostMapping(value = "/child")
	public ChildInfoDTO child(@RequestBody String childseq) {
		return service.childinfo(childseq);
	}
}
