package com.project.apa.api.search.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.project.apa.api.search.model.BookMarkDTO;
import com.project.apa.api.search.model.FindHospitalDTO;
import com.project.apa.api.search.model.HospitalDoctorDTO;
import com.project.apa.api.search.model.HospitalInfoDTO;
import com.project.apa.api.search.model.ReviewDTO;
import com.project.apa.api.search.model.SelfsymtomDTO;
import com.project.apa.api.search.repository.InfoDAO;
import com.project.apa.api.search.repository.ReservationDAO;
import com.project.apa.api.search.repository.SearchDAO;

@Service
public class SearchService {
	
	@Autowired
	private SearchDAO searchdao;
	@Autowired
	private InfoDAO infodao;
	@Autowired
	private ReservationDAO redao;

	public List<SelfsymtomDTO> symtomlist() {
		return searchdao.symtomlist();
	}

	public List<String> findsystomlist(FindHospitalDTO dto) {
		return searchdao.findsystomlist(dto);
	} 
	
	public List<HospitalInfoDTO> findHospitalList(List<String> findsystomlist) {
		return searchdao.findHospitalList(findsystomlist);
	}

	public HospitalInfoDTO hospitalInfo(String seq) {
		return infodao.hospitalInfo(seq);
	}

	public List<SelfsymtomDTO> deptlist(String seq) {
		return infodao.deptlist(seq);
	}

	public List<HospitalDoctorDTO> doclist(String seq) {
		return infodao.doclist(seq);
	}

	public List<ReviewDTO> reviewlist(String seq) {
		return infodao.reviewlist(seq);
	}

	public List<ReviewDTO> reviewtaglist(String seq) {
		return infodao.reviewtaglist(seq);
	}

	public List<BookMarkDTO> bookmarkcount(String seq) {
		return infodao.bookmarkcount(seq);
	}

	public int bookmarkin(BookMarkDTO dto) {
		return infodao.bookmarkin(dto);
	}

	public int bookmarkout(BookMarkDTO dto) {
		return infodao.bookmarkout(dto);
	}

	public List<HospitalDoctorDTO> finddeptdoc(HospitalDoctorDTO dto) {
		return redao.finddeptdoc(dto);
	}
	

}
