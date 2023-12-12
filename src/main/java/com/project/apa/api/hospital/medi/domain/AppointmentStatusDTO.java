package com.project.apa.api.hospital.medi.domain;

import lombok.Data;

@Data
public class AppointmentStatusDTO {
	private String appointmentStatusSeq;
	private String appointmentSeq;
	private String status;
}
