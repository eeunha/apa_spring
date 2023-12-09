package com.project.apa.api.hospital.medi.persistence;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.apa.api.hospital.medi.domain.AppointmentDetailDTO;
import com.project.apa.mapper.HospitalMediMapper;

@Repository
public class AppointmentDetailDAOImpl implements AppointmentDetailDAO {

	@Autowired
	private HospitalMediMapper hospitalMediMapper;

	@Override
	public List<AppointmentDetailDTO> getAllAppointmentDetail(HashMap<String, Object> map) {

		return hospitalMediMapper.getAllAppointmentDetail(map);
	}
}
