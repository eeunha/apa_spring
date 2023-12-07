package com.project.apa.mapper;

import java.util.List;

import com.project.apa.api.search.model.HospitalDoctorDTO;
import com.project.apa.api.search.model.HospitalInfoDTO;
import com.project.apa.api.search.model.ReviewDTO;
import com.project.apa.api.search.model.SelfsymtomDTO;

public interface InfoMapper {
	
	HospitalInfoDTO hospitalInfo(String seq);

	List<SelfsymtomDTO> deptlist(String seq);

	List<HospitalDoctorDTO> doclist(String seq);

	List<ReviewDTO> reviewlist(String seq);

	List<ReviewDTO> reviewtaglist(String seq);
}
