package com.project.apa.api.hospital.medi.persistence;

import java.util.HashMap;
import java.util.List;

import com.project.apa.api.hospital.medi.domain.AppointmentDetailDTO;

public interface AppointmentDetailDAO {

	List<AppointmentDetailDTO> getAllAppointmentDetail(HashMap<String, Object> map);

}
