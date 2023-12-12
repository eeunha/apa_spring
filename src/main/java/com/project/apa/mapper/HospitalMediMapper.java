package com.project.apa.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.project.apa.api.hospital.medi.domain.AppointmentDetailDTO;
import com.project.apa.api.hospital.medi.domain.AppointmentListDTO;
import com.project.apa.api.hospital.medi.domain.AppointmentStatusDTO;
import com.project.apa.api.hospital.medi.domain.PatientDTO;
import com.project.apa.api.hospital.medi.domain.RecordDTO;
import com.project.apa.api.hospital.medi.domain.TreatmentDetailDTO;
import com.project.apa.api.hospital.medi.domain.TreatmentListDTO;

public interface HospitalMediMapper {

	List<PatientDTO> getPatientList(String id);

	List<AppointmentListDTO> getTodayAppointmentList(HashMap<String, Object> map);

	List<AppointmentListDTO> getAllAppointmentList(HashMap<String, Object> map);

	AppointmentDetailDTO getAllAppointmentDetail(int appointmentSeq);

	int getAllAppointmentCount(String id);

	List<TreatmentListDTO> getTreatmentList(HashMap<String, Object> map);

	int getAllTreatmentCount(String id);

	TreatmentDetailDTO getAllTreatmentDetail(int appointmentSeq);

	int approveAppointment(int appointmentSeq);

	int declineAppointment(int appointmentSeq);

	int callPatient(int appointmentSeq);

	int writeMediRecord(Map<String, String> data);

	RecordDTO getInitMediRecord(int appointmentSeq);

	int changeTreatmentStatus(String appointmentSeq);

	int insertDispenseStatus(String dispenseListSeq);

	String getDispenseListSeq(String appointmentSeq);
}
