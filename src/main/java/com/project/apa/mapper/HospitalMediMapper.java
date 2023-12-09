package com.project.apa.mapper;

import java.util.HashMap;
import java.util.List;

import com.project.apa.api.hospital.medi.domain.AppointmentDetailDTO;
import com.project.apa.api.hospital.medi.domain.AppointmentListDTO;
import com.project.apa.api.hospital.medi.domain.PatientDTO;

public interface HospitalMediMapper {

	List<PatientDTO> getPatientList(String id);

	List<AppointmentListDTO> getTodayAppointmentList(HashMap<String, Object> map);

	List<AppointmentListDTO> getAllAppointmentList(HashMap<String, Object> map);

	List<AppointmentDetailDTO> getAllAppointmentDetail(HashMap<String, Object> map);

}
