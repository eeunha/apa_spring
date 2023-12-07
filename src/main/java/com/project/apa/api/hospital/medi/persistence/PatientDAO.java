package com.project.apa.api.hospital.medi.persistence;

import java.util.List;

import com.project.apa.api.hospital.medi.domain.PatientDTO;

public interface PatientDAO {

	List<PatientDTO> getPatientList(String id);

}
