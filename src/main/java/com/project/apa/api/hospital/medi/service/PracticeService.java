package com.project.apa.api.hospital.medi.service;

import java.util.HashMap;
import java.util.List;

import com.project.apa.api.hospital.medi.domain.AppointmentDetailDTO;
import com.project.apa.api.hospital.medi.domain.AppointmentListDTO;
import com.project.apa.api.hospital.medi.domain.TreatmentListDTO;

public interface PracticeService {

	List<AppointmentListDTO> getTodayAppointmentList(HashMap<String, Object> map);

	List<AppointmentListDTO> getAllAppointmentList(HashMap<String, Object> map);

	AppointmentDetailDTO getAllAppointmentDetail(int appointmentSeq);

	String getAllAppointmentListPageBar(HashMap<String, Object> map);

	List<TreatmentListDTO> getAllTreatmentList(HashMap<String, Object> map);

	String getAllTreatmentListPageBar(HashMap<String, Object> map);


}
