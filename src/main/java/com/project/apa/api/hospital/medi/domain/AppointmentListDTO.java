package com.project.apa.api.hospital.medi.domain;

import lombok.Data;

@Data
public class AppointmentListDTO {
	private String rnum;
	private String appointmentSeq;
	private String userName;
	private String childName;
	private String hospitalId;
	private String treatmentWay;
	private String appointmentDate;
	private String doctorName;
	private String symptom;
	private String regdate;
	private String status;
}
