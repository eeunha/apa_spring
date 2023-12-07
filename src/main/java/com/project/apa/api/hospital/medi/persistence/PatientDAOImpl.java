package com.project.apa.api.hospital.medi.persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.apa.api.hospital.medi.domain.PatientDTO;
import com.project.apa.mapper.HospitalMediMapper;

@Repository
public class PatientDAOImpl implements PatientDAO {
	
	@Autowired
	private HospitalMediMapper hospitalMediMapper;
	
	@Override
	public List<PatientDTO> getPatientList() {

		return hospitalMediMapper.getPatientList();
	}
}
