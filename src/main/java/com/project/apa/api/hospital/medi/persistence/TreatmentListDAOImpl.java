package com.project.apa.api.hospital.medi.persistence;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.apa.api.hospital.medi.domain.TreatmentListDTO;
import com.project.apa.mapper.HospitalMediMapper;

@Repository
public class TreatmentListDAOImpl implements TreatmentListDAO {

	@Autowired
	private HospitalMediMapper hospitalMediMapper;

	@Override
	public List<TreatmentListDTO> getTreatmentList(HashMap<String, Object> map) {
		return hospitalMediMapper.getTreatmentList(map);
	}
	
	@Override
	public int getAllTreatmentCount(String id) {
		return hospitalMediMapper.getAllTreatmentCount(id);
	}
	
	@Override
	public List<TreatmentListDTO> getTodayTreatmentList(HashMap<String, Object> map) {
		return hospitalMediMapper.getTodayTreatmentList(map);
	}
	
	@Override
	public int getTodayTreatmentCount(String id) {
		return hospitalMediMapper.getTodayTreatmentCount(id);
	}
}
