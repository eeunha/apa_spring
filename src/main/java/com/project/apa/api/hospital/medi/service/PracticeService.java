package com.project.apa.api.hospital.medi.service;

import java.util.HashMap;
import java.util.List;

import com.project.apa.api.hospital.medi.domain.AppointmentDetailDTO;
import com.project.apa.api.hospital.medi.domain.AppointmentListDTO;

public interface PracticeService {

	List<AppointmentListDTO> getTodayAppointmentList(HashMap<String, Object> map);

	List<AppointmentListDTO> getAllAppointmentList(HashMap<String, Object> map);

	List<AppointmentDetailDTO> getAllAppointmentDetail(HashMap<String, Object> map);

}
