package com.project.apa.api.hospital.medi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.apa.api.hospital.medi.domain.PatientDTO;

public interface PatientService {

	List<PatientDTO> getPatientList(String id);

}
