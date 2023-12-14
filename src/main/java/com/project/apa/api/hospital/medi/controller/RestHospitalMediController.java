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

/**
 * 병원 - 내 진료에서 사용되는 데이터를 가져오는 REST API 컨트롤러입니다.
 * 
 * @author Eunha
 *
 */
@RestController
@RequestMapping("/api/hospital/{id}/medi")
public class RestHospitalMediController {

	@Autowired
	private PatientService patientService;

	@Autowired
	private PracticeService practiceService;

	// 오늘의 진료 예약 목록 가져오기
	@GetMapping(value = "/today/appointment")
	public Map<String, Object> getTodayAppointmentList(@PathVariable(name = "id") String id,
			@RequestParam(defaultValue = "1") int page) {

//		System.out.println("id: " + id);
//		System.out.println("page: " + page);

		HashMap<String, Object> map = new HashMap<>();
		map.put("id", id);
		map.put("page", page);

		return practiceService.getTodayAppointmentList(map);
	}

	// 오늘의 진료 예약 상세 내역 가져오기 => 

	// 오늘의 진료 내역 목록 가져오기
	@GetMapping(value = "/today/treatment")
	public Map<String, Object> getTodayTreatmentList(@PathVariable(name = "id") String id,
			@RequestParam(defaultValue = "1") int page) {

		System.out.println("id: " + id);
		System.out.println("page: " + page);

		HashMap<String, Object> map = new HashMap<>();
		map.put("id", id);
		map.put("page", page);
		
		return practiceService.getTodayTreatmentList(map);
	}
	
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
	public AppointmentDetailDTO getAppointmentDetail(@PathVariable int appointmentSeq) {

		return practiceService.getAppointmentDetail(appointmentSeq);
	}

	// 진료 예약 승인/거절
	@PutMapping(value = "/appointment/{appointmentSeq}")
//	public int handleAppointment(@PathVariable int appointmentSeq, @RequestParam String data) {
	public int handleAppointment(@PathVariable int appointmentSeq, @RequestBody Map<String, String> data) {

		String action = data.get("action");
//
//		System.out.println("data: " + data);

		// 승인할 경우
		if (action.equals("approve")) {
//		if (data.equals("approve")) {

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
	public int handleTreatmentDetail(@PathVariable int appointmentSeq, @RequestBody HashMap<String, String> data) {

		String action = data.get("action");

		System.out.println("action: " + action);

		// 환자를 호출할 경우
		if (action.equals("call")) {

			return practiceService.callPatient(appointmentSeq);
		}

		// 진료완료를 할 경우(예방접종, 건강검진만)
		return practiceService.completeTreatment(appointmentSeq + "");

	}

	// 진료내역서 작성하기 + 진료완료처리
	@PutMapping(value = "/all/treatment/{appointmentSeq}/record")
	public int writeMediRecord(Model model, @RequestBody HashMap<String, String> data) {

		// 일단 형변환 없이 String으로 진행해보자.

		return practiceService.writeMediRecord(data);
	}

	// 내원환자 목록 가져오기
	@GetMapping(value = "/patient")
	public List<PatientDTO> getPatientList(@PathVariable String id) {

		return patientService.getPatientList(id);
	}
}
