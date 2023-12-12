package com.project.apa.api.hospital.medi.persistence;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.apa.api.hospital.medi.domain.RecordDTO;
import com.project.apa.mapper.HospitalMediMapper;

@Repository
public class RecordDAOImpl implements RecordDAO {
	
	@Autowired
	private HospitalMediMapper hospitalMediMapper;
	
	@Override
	public RecordDTO getInitMediRecord(int appointmentSeq) {

		return hospitalMediMapper.getInitMediRecord(appointmentSeq);
	}
	
	@Override
	public int writeMediRecord(Map<String, String> data) {

		return hospitalMediMapper.writeMediRecord(data);
	}
	
	@Override
	public int changeTreatmentStatus(String appointmentSeq) {

		return hospitalMediMapper.changeTreatmentStatus(appointmentSeq);
	}
	
	@Override
	public String getDispenseListSeq(String appointmentSeq) {
		return hospitalMediMapper.getDispenseListSeq(appointmentSeq);
	}
	
	@Override
	public int insertDispenseStatus(String dispenseListSeq) {

		return hospitalMediMapper.insertDispenseStatus(dispenseListSeq);
	}
}
