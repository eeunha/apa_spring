package com.project.apa.api.hospital.medi.domain;

import lombok.Data;

@Data
public class AppointmentDetailDTO {
	// 예약번호 병원아이디
	// 접수자번호 접수자이름 접수자전화번호 환자와의관계 접수자주소
	// 환자번호 환자이름 환자주민등록번호
	// 예약일시 진료방식 진료과목 의사 상세증상 신청일시
	// 예약상태

	private String appointmentSeq;
	private String hospitalId;
	
	private String userSeq;
	private String userName;
	private String userRelation;
	private String userSSN;
	private String userTel;
	private String userAddress;
	
	private String childSeq;
	private String childName;
	private String childSSN;
	
	private String appointmentDate;
	private String treatmentWay;
	private String departmentName;
	private String doctorName;
	private String symptom;
	private String regdate;

	private String status;
}
