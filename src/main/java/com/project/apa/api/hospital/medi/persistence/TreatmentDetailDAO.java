package com.project.apa.api.hospital.medi.persistence;

import com.project.apa.api.hospital.medi.domain.RecordDTO;
import com.project.apa.api.hospital.medi.domain.TreatmentDetailDTO;

public interface TreatmentDetailDAO {

	TreatmentDetailDTO getAllTreatmentDetail(int appointmentSeq);

	int callPatient(int appointmentSeq);

}
