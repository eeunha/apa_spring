package com.project.apa.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import com.project.apa.search.HospitalInfoDTO;
import com.project.apa.search.SelfsymtomDTO;

public interface SearchMapper {
	
	
	@Select("select * from tblselfsymtom")
	List<SelfsymtomDTO> symtomlist();

	List<HospitalInfoDTO> findHospitalList(List<String> findsystomlist);

	List<String> findsystomlist(String seq1, String seq2, String seq3, String seq4, String seq5, String seq6,
			String seq7, String seq8);

}
