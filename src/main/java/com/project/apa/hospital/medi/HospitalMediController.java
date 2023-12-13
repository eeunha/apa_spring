package com.project.apa.hospital.medi;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.apa.api.hospital.medi.domain.AppointmentDetailDTO;
import com.project.apa.api.hospital.medi.domain.AppointmentListDTO;
import com.project.apa.api.hospital.medi.domain.PatientDTO;
import com.project.apa.api.hospital.medi.domain.RecordDTO;
import com.project.apa.api.hospital.medi.domain.TreatmentDetailDTO;
import com.project.apa.api.hospital.medi.domain.TreatmentListDTO;
import com.project.apa.api.hospital.medi.service.PatientService;
import com.project.apa.api.hospital.medi.service.PracticeService;

/**
 * 병원의 내 진료 페이지 내부의 렌더링을 위한 컨트롤러입니다.
 * 
 * @author Eunha
 *
 */
@Controller
@RequestMapping("/hospital/{id}/medi")
public class HospitalMediController {

	@Autowired
	private PatientService patientService;

	@Autowired
	private PracticeService practiceService;

	public HospitalMediController(PatientService patientService, PracticeService practiceService) {
		this.patientService = patientService;
		this.practiceService = practiceService;
	}

	// 오늘의 진료 - 예약 - 목록
	@GetMapping(value = "/today/appointment")
	public String getToadyAppointmentList(Model model, @PathVariable String id,
			@RequestParam(defaultValue = "1") int page) {

		model.addAttribute("page", page);
		
		return "hospital.medi.today.appointment-list";
	}

	// 오늘의 진료 - 진료 - 목록
	@GetMapping(value = "/today/treatment")
	public String getTodayTreatmentList(Model model) {

		return "hospital.medi.today.treatment-list";
	}

	// 모든 진료 - 예약 - 목록
	@GetMapping(value = "/all/appointment")
	public String getAllAppointmentList(Model model, @PathVariable String id,
			@RequestParam(defaultValue = "1") int page) {

		System.out.println("page: " + page);

		HashMap<String, Object> map = new HashMap<>();
		map.put("id", id);
		map.put("page", page);

		List<AppointmentListDTO> appointmentList = practiceService.getAllAppointmentList(map);

		// 페이지바 생성하기
		String pagebar = practiceService.getAllAppointmentListPageBar(map);

		model.addAttribute("pagebar", pagebar);
		model.addAttribute("appointmentList", appointmentList);

		return "hospital.medi.all.appointment-list";
	}

	/**
	 * 모든 진료 예약 세부 내역 페이지를 렌더링하는 메소드입니다.
	 * 
	 * @param model
	 * @param appointmentSeq
	 * @return
	 */
	@GetMapping(value = "/all/appointment/{appointmentSeq}")
	public String getAllAppointmentDetail(Model model, @PathVariable int appointmentSeq) {

		AppointmentDetailDTO dto = practiceService.getAllAppointmentDetail(appointmentSeq);

		model.addAttribute("dto", dto);

		return "hospital.medi.all.appointment-detail";
	}

	// 모든 진료 - 진료 - 목록
	@GetMapping(value = "/all/treatment")
	public String getAllTreatmentList(Model model, @PathVariable String id,
			@RequestParam(defaultValue = "1") int page) {

		HashMap<String, Object> map = new HashMap<>();
		map.put("id", id);
		map.put("page", page);

		List<TreatmentListDTO> treatmentList = practiceService.getAllTreatmentList(map);

		// 페이지바
		String pagebar = practiceService.getAllTreatmentListPageBar(map);

		model.addAttribute("treatmentList", treatmentList);
		model.addAttribute("pagebar", pagebar);

		return "hospital.medi.all.treatment-list";
	}

	/**
	 * 병원 - 내 진료 - 모든 진료 - 진료 상세보기
	 * 
	 * @param model
	 * @param appointmentSeq
	 * @return
	 */
	@GetMapping(value = "/all/treatment/{appointmentSeq}")
	public String getAllTreatmentDetail(Model model, @PathVariable int appointmentSeq) {

		TreatmentDetailDTO dto = practiceService.getAllTreatmentDetail(appointmentSeq);

		model.addAttribute("dto", dto);

		return "hospital.medi.all.treatment-detail";
	}

	@GetMapping(value = "/all/treatment/{appointmentSeq}/record")
	public String writeMediRecord(Model model, @PathVariable int appointmentSeq) {

		// 기본 내용 가져오기 - 예약번호, 병원이름, 의사이름
		RecordDTO dto = practiceService.getInitMediRecord(appointmentSeq);

		model.addAttribute("dto", dto);

		return "hospital.medi.all.medi-record";
	}

	@GetMapping(value = "/patient")
	public String getPatientList(Model model, @PathVariable String id) {

		List<PatientDTO> patientList = patientService.getPatientList(id);

		model.addAttribute("patientList", patientList);

		return "hospital.medi.patient";
	}
}
