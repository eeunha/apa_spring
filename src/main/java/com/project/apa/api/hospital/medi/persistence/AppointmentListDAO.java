package com.project.apa.api.hospital.medi.persistence;

import java.util.List;

import com.project.apa.api.hospital.medi.domain.AppointmentListDTO;

public interface AppointmentListDAO {

	List<AppointmentListDTO> getTodayAppointmentList(String id);

}
