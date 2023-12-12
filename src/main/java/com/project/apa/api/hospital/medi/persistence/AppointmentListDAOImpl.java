package com.project.apa.api.hospital.medi.persistence;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.apa.api.hospital.medi.domain.AppointmentListDTO;
import com.project.apa.mapper.HospitalMediMapper;

@Repository
public class AppointmentListDAOImpl implements AppointmentListDAO {

	@Autowired
	private HospitalMediMapper hospitalMediMapper;

	@Override
	public List<AppointmentListDTO> getTodayAppointmentList(HashMap<String, Object> map) {

		return hospitalMediMapper.getTodayAppointmentList(map);
	}

	@Override
	public List<AppointmentListDTO> getAllAppointmentList(HashMap<String, Object> map) {

		return hospitalMediMapper.getAllAppointmentList(map);
	}

	@Override
	public int getAllAppointmentCount(String id) {
		
		return hospitalMediMapper.getAllAppointmentCount(id);
	}
}