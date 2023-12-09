package com.project.apa.api.hospital.medi.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.apa.api.hospital.medi.domain.AppointmentDetailDTO;
import com.project.apa.api.hospital.medi.domain.AppointmentListDTO;
import com.project.apa.api.hospital.medi.domain.PatientDTO;
import com.project.apa.api.hospital.medi.service.PatientService;
import com.project.apa.api.hospital.medi.service.PracticeService;

@RestController
//@RequestMapping("/api/hospital/medi")
@RequestMapping("/api/hospital/{id}/medi")
public class RestHospitalMediController {

	@Autowired
	private PatientService patientService;

	@Autowired
	private PracticeService practiceService;

	// 오늘의 진료 예약 목록 가져오기
	@GetMapping(value = "/today/appointment")
	public List<AppointmentListDTO> getTodayAppointmentList(@PathVariable String id,
			@RequestParam(defaultValue = "1") int start, @RequestParam(defaultValue = "10") int end) {

		HashMap<String, Object> map = new HashMap<>();
		map.put("id", id);
		map.put("start", start);
		map.put("end", end);
		
		return practiceService.getTodayAppointmentList(map);
	}

	// 오늘의 진료 예약 상세 내역 가져오기

	// 오늘의 진료 내역 목록 가져오기

	// 오늘의 진료 상세 내역 가져오기

	// 모든 진료 예약 목록 가져오기
	@GetMapping(value = "/all/appointment")
	public List<AppointmentListDTO> getAllAppointmentList(@PathVariable String id,
			@RequestParam(defaultValue = "1") int start, @RequestParam(defaultValue = "10") int end) {

		HashMap<String, Object> map = new HashMap<>();
		map.put("id", id);
		map.put("start", start);
		map.put("end", end);

		return practiceService.getAllAppointmentList(map);
	}

	// 모든 진료 예약 상세 내역 가져오기
	@GetMapping(value = "/all/appointment/${appointmentSeq}")
	public List<AppointmentDetailDTO> getAllAppointmentDetail(@PathVariable String id, @PathVariable int appointmentSeq) {
		
		HashMap<String, Object> map = new HashMap<>();
		map.put("id", id);
		map.put("appointmentSeq", appointmentSeq);
		
		return practiceService.getAllAppointmentDetail(map);
	}

	// 내원환자 목록 가져오기
	@GetMapping(value = "/patient")
	public List<PatientDTO> getPatientList(@PathVariable String id) {

		return patientService.getPatientList(id);
	}
}
