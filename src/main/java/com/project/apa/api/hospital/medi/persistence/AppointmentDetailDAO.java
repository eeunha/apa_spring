package com.project.apa.api.hospital.medi.persistence;

import com.project.apa.api.hospital.medi.domain.AppointmentDetailDTO;
import com.project.apa.api.hospital.medi.domain.AppointmentStatusDTO;

public interface AppointmentDetailDAO {

	AppointmentDetailDTO getAppointmentDetail(int appointmentSeq);

	int approveAppointment(int appointmentSeq);

	int declineAppointment(int appointmentSeq);

}
