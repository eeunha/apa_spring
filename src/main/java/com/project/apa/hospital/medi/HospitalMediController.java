package com.project.apa.hospital.medi;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hospital/medi")
public class HospitalMediController {

	@GetMapping(value = "/main")
	public String main(Model model) {

		return "hospital.medi.main";
	}

	@GetMapping(value = "/patient")
	public String patient(Model model) {

		return "hospital.medi.patient";
	}

//	@GetMapping(value = "/today/appointment.do")
//	public String appointment(Model model) {
//		
//		return "hospital.medi.today-appointment";
//	}
}
