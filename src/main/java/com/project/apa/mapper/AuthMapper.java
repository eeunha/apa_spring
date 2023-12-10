package com.project.apa.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.project.apa.auth.model.MemberDTO;

@Mapper
public interface AuthMapper {
	MemberDTO read(String username);
	
	  @Select ("select * from tbluser") 
	  List<MemberDTO> mymy();
	  void encode(MemberDTO dto);
}
