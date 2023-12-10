package com.project.apa.mapper;

import java.util.HashMap;
import java.util.List;

import com.project.apa.api.hospital.medi.domain.AppointmentDetailDTO;
import com.project.apa.api.hospital.medi.domain.AppointmentListDTO;
import com.project.apa.api.hospital.medi.domain.PatientDTO;
import com.project.apa.api.hospital.medi.domain.TreatmentListDTO;

public interface HospitalMediMapper {

	List<PatientDTO> getPatientList(String id);

	List<AppointmentListDTO> getTodayAppointmentList(HashMap<String, Object> map);

	List<AppointmentListDTO> getAllAppointmentList(HashMap<String, Object> map);

	AppointmentDetailDTO getAllAppointmentDetail(int appointmentSeq);

	int getAllAppointmentCount(String id);

	List<TreatmentListDTO> getTreatmentList(HashMap<String, Object> map);

	int getAllTreatmentCount(String id);
}
