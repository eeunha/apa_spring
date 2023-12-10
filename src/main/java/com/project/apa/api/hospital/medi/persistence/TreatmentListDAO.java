package com.project.apa.api.hospital.medi.persistence;

import java.util.HashMap;
import java.util.List;

import com.project.apa.api.hospital.medi.domain.TreatmentListDTO;

public interface TreatmentListDAO {

	List<TreatmentListDTO> getTreatmentList(HashMap<String, Object> map);

	int getAllTreatmentCount(String id);

}
