package com.project.apa.api.hospital.medi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.apa.api.hospital.medi.domain.AppointmentDetailDTO;
import com.project.apa.api.hospital.medi.domain.AppointmentListDTO;
import com.project.apa.api.hospital.medi.persistence.AppointmentListDAO;

@Service
public class PracticeServiceImpl implements PracticeService {

	@Autowired
	private AppointmentListDAO appointmentListDAO;
	
	@Override
	public List<AppointmentListDTO> getTodayAppointmentList(String id) {

		return appointmentListDAO.getTodayAppointmentList(id);
	}
}
