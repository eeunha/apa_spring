package com.project.apa.api.hospital.medi.domain;

import lombok.Data;

@Data
public class AppointmentDetailDTO {
	private String appointmentSeq;
	private String hospitalId;
	private String userSeq;
	private String childSeq;
	private String treatmentWay;
	private String doctorSeq;
	private String appointmentDate;
	private String regdate;
	private String symptom;
}
