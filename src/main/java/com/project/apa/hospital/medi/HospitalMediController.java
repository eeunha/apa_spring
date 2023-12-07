package com.project.apa.hospital.medi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.apa.api.hospital.medi.domain.AppointmentListDTO;
import com.project.apa.api.hospital.medi.domain.PatientDTO;
import com.project.apa.api.hospital.medi.service.PatientService;
import com.project.apa.api.hospital.medi.service.PracticeService;

@Controller
@RequestMapping("/hospital/{id}/medi")
public class HospitalMediController {

	@Autowired
	private PatientService patientService;

	@Autowired
	private PracticeService practiceService;

	public HospitalMediController(PatientService patientService) {
		this.patientService = patientService;
	}

	@GetMapping(value = "/today/appointment")
	public String toadyAppointment(Model model, @PathVariable String id) {

		List<AppointmentListDTO> appointmentList = practiceService.getTodayAppointmentList(id);
		model.addAttribute("appointmentList", appointmentList);
		return "hospital.medi.today.appointment";
	}

	@GetMapping(value = "/today/treatment")
	public String todayTreatment(Model model) {

		return "hospital.medi.today.treatment";
	}

	@GetMapping(value = "/all/appointment")
	public String allAppointment(Model model) {

		return "hospital.medi.all.appointment";
	}

	@GetMapping(value = "/all/treatment")
	public String allTreatment(Model model) {

		return "hospital.medi.all.treatment";
	}

	@GetMapping(value = "/patient")
	public String patient(Model model) {

		List<PatientDTO> patientList = patientService.getPatientList();

		model.addAttribute("patientList", patientList);

		return "hospital.medi.patient";
	}
}
