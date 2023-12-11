package com.project.apa.mapper;

import java.util.List;

import com.project.apa.api.search.model.HospitalDoctorDTO;

public interface ReservationMapper {

	List<HospitalDoctorDTO> finddeptdoc(HospitalDoctorDTO dto);

}
