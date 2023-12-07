package com.project.apa.api.hospital.medi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.apa.api.hospital.medi.domain.PatientDTO;
import com.project.apa.api.hospital.medi.service.PatientService;

@RestController
@RequestMapping("/api/hospital/medi")
public class RestHospitalMediController {

	@Autowired
	private PatientService patientService;

//	@GetMapping(value = "/treatment")
//	public String treatment() {
//
//		return "treatment";
//	}

	@GetMapping(value = "/patient")
	public List<PatientDTO> getPatientList() {

		return patientService.getPatientList();
	}
}
