package com.project.apa.auth.model;

import java.util.List;

import lombok.Data;

@Data
public class MemberDTO {
	private String userseq;
	private String username;
	private String userssn;
	private String userid;
	private String userpw;
	private String usertel;
	private String useraddress;
	private String useremail;
	private String userrelation;
	private String usercautioncount;
	private String registerdate;
	private String isuserunregister;
	
	private List<AuthDTO> authlist;
	
}
