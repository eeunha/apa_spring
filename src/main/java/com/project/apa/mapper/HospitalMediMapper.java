package com.project.apa.mapper;

import java.util.List;

import com.project.apa.api.hospital.medi.domain.AppointmentListDTO;
import com.project.apa.api.hospital.medi.domain.PatientDTO;

public interface HospitalMediMapper {

	List<PatientDTO> getPatientList(String id);

	List<AppointmentListDTO> getTodayAppointmentList(String id);
	
	
}
