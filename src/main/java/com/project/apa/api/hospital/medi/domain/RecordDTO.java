package com.project.apa.api.hospital.medi.domain;

import lombok.Data;

@Data
public class RecordDTO {
	private String appointmentSeq;

	private String recordSeq;
	private String hospitalId;
	private String hospitalName;
	private String doctorName;
	private String diagnosis;
	private String diseaseCode;
	private String recordContent;
}
