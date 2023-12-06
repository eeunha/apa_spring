package com.project.apa.search;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.apa.mapper.SearchMapper;

@Repository
public class SearchDAO {
	private final SearchMapper mapper;
	
	@Autowired
	public SearchDAO(SearchMapper mapper) {
		this.mapper = mapper;
	}

	//자가진단
	public List<SelfsymtomDTO> symtomlist() {
		return mapper.symtomlist();
	}

	public List<HospitalInfoDTO> findHospitalList(List<String> findsystomlist) {
		
		return mapper.findHospitalList(findsystomlist);
	}

	public List<String> findsystomlist(String seq1, String seq2, String seq3, String seq4, String seq5, String seq6,
			String seq7, String seq8) {
		return mapper.findsystomlist(seq1,seq2,seq3,seq4,seq5,seq6,seq7,seq8);
	}
	
	
}
