package com.project.apa.api.hospital.medi.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.project.apa.api.hospital.medi.domain.AppointmentDetailDTO;
import com.project.apa.api.hospital.medi.domain.AppointmentListDTO;
import com.project.apa.api.hospital.medi.domain.AppointmentStatusDTO;
import com.project.apa.api.hospital.medi.domain.RecordDTO;
import com.project.apa.api.hospital.medi.domain.TreatmentDetailDTO;
import com.project.apa.api.hospital.medi.domain.TreatmentListDTO;

public interface PracticeService {

	List<AppointmentListDTO> getTodayAppointmentList(HashMap<String, Object> map);

	List<AppointmentListDTO> getAllAppointmentList(HashMap<String, Object> map);

	AppointmentDetailDTO getAllAppointmentDetail(int appointmentSeq);

	String getAllAppointmentListPageBar(HashMap<String, Object> map);

	List<TreatmentListDTO> getAllTreatmentList(HashMap<String, Object> map);

	String getAllTreatmentListPageBar(HashMap<String, Object> map);

	TreatmentDetailDTO getAllTreatmentDetail(int appointmentSeq);

	int approveAppointment(int appointmentSeq);

	int declineAppointment(int appointmentSeq);

	int callPatient(int appointmentSeq);

	RecordDTO getInitMediRecord(int appointmentSeq);

	int writeMediRecord(Map<String, String> data);

	int completeTreatment(String string);


}
