package com.project.apa.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.project.apa.search.SelfsymtomDTO;

public interface SearchMapper {
	
	@Select("select * from tblselfsymtom")
	List<SelfsymtomDTO> symtomlist();

}
