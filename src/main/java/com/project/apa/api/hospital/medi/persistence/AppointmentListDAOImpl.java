package com.project.apa.api.hospital.medi.persistence;

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
	public List<AppointmentListDTO> getTodayAppointmentList(String id) {

		return hospitalMediMapper.getTodayAppointmentList(id);
	}
}
