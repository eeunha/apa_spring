package com.project.apa.api.hospital.medi.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.apa.api.hospital.medi.domain.AppointmentDetailDTO;
import com.project.apa.api.hospital.medi.domain.AppointmentListDTO;
import com.project.apa.api.hospital.medi.persistence.AppointmentDetailDAO;
import com.project.apa.api.hospital.medi.persistence.AppointmentListDAO;

@Service
public class PracticeServiceImpl implements PracticeService {

	@Autowired
	private AppointmentListDAO appointmentListDAO;

	@Autowired
	private AppointmentDetailDAO appointmentDetailDAO;

	@Override
	public List<AppointmentListDTO> getTodayAppointmentList(HashMap<String, Object> map) {

		return appointmentListDAO.getTodayAppointmentList(map);
	}

	@Override
	public List<AppointmentListDTO> getAllAppointmentList(HashMap<String, Object> map) {

		return appointmentListDAO.getAllAppointmentList(map);
	}
	
	@Override
	public List<AppointmentDetailDTO> getAllAppointmentDetail(HashMap<String, Object> map) {

		return appointmentDetailDAO.getAllAppointmentDetail(map);
	}
}
