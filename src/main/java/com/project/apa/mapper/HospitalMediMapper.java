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

	AppointmentDetailDTO getAppointmentDetail(int appointmentSeq);

	int getAllAppointmentCount(String id);

	List<TreatmentListDTO> getAllTreatmentList(HashMap<String, Object> map);

	int getAllTreatmentCount(String id);

	TreatmentDetailDTO getTreatmentDetail(int appointmentSeq);

	int approveAppointment(int appointmentSeq);

	int declineAppointment(int appointmentSeq);

	int callPatient(int appointmentSeq);

	int writeMediRecord(Map<String, String> data);

	RecordDTO getInitMediRecord(int appointmentSeq);

	int changeTreatmentStatus(String appointmentSeq);

	int insertDispenseStatus(String dispenseListSeq);

	String getDispenseListSeq(String appointmentSeq);

	int getTodayAppointmentCount(String id);

	List<TreatmentListDTO> getTodayTreatmentList(HashMap<String, Object> map);

	int getTodayTreatmentCount(String id);

	List<TreatmentListDTO> getAllTreatmentListOldRegDate(HashMap<String, Object> map);

	List<TreatmentListDTO> getAllTreatmentListLastRegDate(HashMap<String, Object> map);

	List<TreatmentListDTO> getAllTreatmentListAppointmentSeq(HashMap<String, Object> map);

	List<AppointmentListDTO> getAllAppointmentListOld(HashMap<String, Object> map);

	List<AppointmentListDTO> getAllAppointmentListLast(HashMap<String, Object> map);
}
