package com.project.apa.api.search.repository;

import java.util.List;

import com.project.apa.api.search.model.HospitalDoctorDTO;

public interface ReservationDAO {

	List<HospitalDoctorDTO> finddeptdoc(HospitalDoctorDTO dto);

}
