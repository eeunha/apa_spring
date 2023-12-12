package com.project.apa.api.hospital.medi.persistence;

import java.util.Map;

import com.project.apa.api.hospital.medi.domain.RecordDTO;

public interface RecordDAO {

	RecordDTO getInitMediRecord(int appointmentSeq);

	int writeMediRecord(Map<String, String> data);

	int changeTreatmentStatus(String appointmentSeq);

	int insertDispenseStatus(String dispenseListSeq);

	String getDispenseListSeq(String appointmentSeq);

}
