package com.project.apa.api.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.apa.api.admin.domain.AfterDTO;
import com.project.apa.api.admin.domain.BlackDTO;
import com.project.apa.api.admin.domain.MemberDTO;
import com.project.apa.api.admin.domain.ReportDTO;
import com.project.apa.api.admin.persistence.AdminMemberDAO;
import com.project.apa.api.admin.persistence.AfterDAO;
import com.project.apa.api.admin.persistence.BlackDAO;
import com.project.apa.api.admin.persistence.ReportDAO;

@Service
public class AdminService {

	@Autowired
	private BlackDAO blackdao;
	
	@Autowired
	private ReportDAO reportdao;
	
	@Autowired
	private AfterDAO afterdao;

	@Autowired
	private AdminMemberDAO memberdao;
	
	public List<BlackDTO> blacklist() {
		
		return blackdao.blacklist();
	}

	public int blacklistadd(BlackDTO dto) {

		return blackdao.blacklistadd(dto);
	}
	
	public int blacklistdel(BlackDTO dto) {
		
		return blackdao.blacklistdel(dto);
	}

	public List<AfterDTO> afterlist() {
		return afterdao.afterlist();
	}

	public List<AfterDTO> afterview(String hospitalId) {

		return afterdao.afterview(hospitalId);
	}

	public int afteredit(AfterDTO dto) {

		return afterdao.afteredit(dto);
	}
	
	public List<ReportDTO> postreportlist() {
		
		return reportdao.postreportlist();
	}

	public List<ReportDTO> commentreportlist() {
		return reportdao.commentreportlist();
	}
	
	public int postreportapprove(ReportDTO dto) {
		return reportdao.postreportapprove(dto);
	}

	public int postreportdecline(ReportDTO dto) {
		return reportdao.postreportdecline(dto);
	}
	
	public int cautionAdd(ReportDTO dto) {
		return reportdao.cautionAdd(dto);
	}

	public int commentreportapprove(ReportDTO dto) {
		return reportdao.commentreportapprove(dto);
	}
	
	public int commentreportdecline(ReportDTO dto) {
		return reportdao.commentreportdecline(dto);
	}

	public List<ReportDTO> postreportview(String communityWriter) {
		return reportdao.postreportview(communityWriter);
	}

	public List<ReportDTO> commentreportview(String commentWriter) {
		return reportdao.commentreportview(commentWriter);
	}

	public int postprivate(ReportDTO dto) {
		return reportdao.postprivate(dto);
	}

	public List<MemberDTO> userInfo() {

		return memberdao.userInfo();
	}

	public List<MemberDTO> hospitalInfo() {
		
		return memberdao.hospitalInfo();
	}

	public List<MemberDTO> pharmacyInfo() {

		return memberdao.pharmacyInfo();
	}

}
