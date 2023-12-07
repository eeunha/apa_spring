package com.project.apa.api.hospital.medi.service;

import java.util.List;

import com.project.apa.api.hospital.medi.domain.AppointmentListDTO;

public interface PracticeService {

	List<AppointmentListDTO> getTodayAppointmentList(String id);

}
