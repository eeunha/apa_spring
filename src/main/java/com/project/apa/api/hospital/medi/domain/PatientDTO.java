package com.project.apa.api.hospital.medi.domain;

import lombok.Data;

@Data
public class PatientDTO {

	private String tblUser;
	private String userSeq;
	private String userName;
	private String userSSN;
	private String userId;
	private String userPw;
	private String userTel;
	private String userAddress;
	private String userEmail;
	private String userRelation;
	private String registerDate;
	private String isUserUnregister;
}
