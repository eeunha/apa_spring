package com.project.apa.api.hospital.medi.persistence;

import java.util.HashMap;
import java.util.List;

import com.project.apa.api.hospital.medi.domain.AppointmentListDTO;

public interface AppointmentListDAO {

	List<AppointmentListDTO> getTodayAppointmentList(HashMap<String, Object> map);

	List<AppointmentListDTO> getAllAppointmentList(HashMap<String, Object> map);

	int getAllAppointmentCount(String id);

}
