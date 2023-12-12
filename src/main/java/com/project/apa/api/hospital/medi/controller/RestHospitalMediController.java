package com.project.apa.api.hospital.medi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.apa.api.hospital.medi.domain.AppointmentDetailDTO;
import com.project.apa.api.hospital.medi.domain.AppointmentListDTO;
import com.project.apa.api.hospital.medi.domain.PatientDTO;
import com.project.apa.api.hospital.medi.domain.TreatmentDetailDTO;
import com.project.apa.api.hospital.medi.domain.TreatmentListDTO;
import com.project.apa.api.hospital.medi.service.PatientService;
import com.project.apa.api.hospital.medi.service.PracticeService;

@RestController
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
			@RequestParam(defaultValue = "1") int page) {

		HashMap<String, Object> map = new HashMap<>();
		map.put("id", id);
		map.put("page", page);

		return practiceService.getAllAppointmentList(map);
	}

	// 모든 진료 예약 상세 내역 가져오기
	@GetMapping(value = "/all/appointment/{appointmentSeq}")
	public AppointmentDetailDTO getAllAppointmentDetail(@PathVariable int appointmentSeq) {

		return practiceService.getAllAppointmentDetail(appointmentSeq);
	}

	// 모든 진료 예약 승인/거절
	@PutMapping(value = "/all/appointment/{appointmentSeq}")
	public int handleAppointment(@PathVariable int appointmentSeq, @RequestBody Map<String, String> data) {

		String action = data.get("action");

		System.out.println("action: " + action);

		// 승인할 경우
		if (action.equals("approve")) {

			return practiceService.approveAppointment(appointmentSeq);
		}

		// 거절할 경우
		return practiceService.declineAppointment(appointmentSeq);
	}

	// 모든 진료 내역 목록 가져오기
	@GetMapping(value = "/all/treatment")
	public List<TreatmentListDTO> getAllTreatmentList(@PathVariable String id,
			@RequestParam(defaultValue = "1") int page) {

		HashMap<String, Object> map = new HashMap<>();
		map.put("id", id);
		map.put("page", page);

		return practiceService.getAllTreatmentList(map);
	}

	// 모든 진료 내역 상세정보 가져오기
	@GetMapping(value = "/all/treatment/{appointmentSeq}")
	public TreatmentDetailDTO getAllTreatmentDetail(@PathVariable int appointmentSeq) {

		return practiceService.getAllTreatmentDetail(appointmentSeq);
	}

	// 모든 진료 내역 - 환자 호출하기
	@PutMapping(value = "/all/treatment/{appointmentSeq}")
	public int callPatient(@PathVariable int appointmentSeq) {

		return practiceService.callPatient(appointmentSeq);
	}

	// 진료내역서 작성하기 + 진료완료처리
	@PutMapping(value = "/all/treatment/{appointmentSeq}/record")
	public int writeMediRecord(Model model, @RequestBody HashMap<String, String> data) {

		//일단 형변환 없이 String으로 진행해보자.
		
		return practiceService.writeMediRecord(data);
	}

	// 내원환자 목록 가져오기
	@GetMapping(value = "/patient")
	public List<PatientDTO> getPatientList(@PathVariable String id) {

		return patientService.getPatientList(id);
	}
}