package com.project.apa.api.hospital.medi.persistence;

import java.util.HashMap;
import java.util.List;

import com.project.apa.api.hospital.medi.domain.TreatmentListDTO;

public interface TreatmentListDAO {

	List<TreatmentListDTO> getAllTreatmentList(HashMap<String, Object> map);

	int getAllTreatmentCount(String id);

	List<TreatmentListDTO> getTodayTreatmentList(HashMap<String, Object> map);

	int getTodayTreatmentCount(String id);

	List<TreatmentListDTO> getAllTreatmentListOldRegDate(HashMap<String, Object> map);

	List<TreatmentListDTO> getAllTreatmentListLastRegDate(HashMap<String, Object> map);

	List<TreatmentListDTO> getAllTreatmentListAppointmentSeq(HashMap<String, Object> map);

}
