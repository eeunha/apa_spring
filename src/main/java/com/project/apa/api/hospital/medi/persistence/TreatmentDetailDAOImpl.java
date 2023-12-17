package com.project.apa.api.hospital.medi.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.apa.api.hospital.medi.domain.RecordDTO;
import com.project.apa.api.hospital.medi.domain.TreatmentDetailDTO;
import com.project.apa.mapper.HospitalMediMapper;

@Repository
public class TreatmentDetailDAOImpl implements TreatmentDetailDAO {
	@Autowired
	private HospitalMediMapper hospitalMediMapper;

	@Override
	public TreatmentDetailDTO getTreatmentDetail(int appointmentSeq) {
		return hospitalMediMapper.getTreatmentDetail(appointmentSeq);
	}

	@Override
	public int callPatient(int appointmentSeq) {

		return hospitalMediMapper.callPatient(appointmentSeq);
	}

}
