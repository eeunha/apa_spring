package com.project.apa.api.search;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.apa.api.search.model.BookMarkDTO;
import com.project.apa.api.search.model.FindHospitalDTO;
import com.project.apa.api.search.model.HospitalInfoDTO;
import com.project.apa.api.search.service.SearchService;

@RestController
@RequestMapping("/search")
public class RestReservationController {
	
	@Autowired
	private SearchService service;
}
