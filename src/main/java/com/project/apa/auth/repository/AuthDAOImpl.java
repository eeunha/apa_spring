package com.project.apa.auth.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.apa.auth.model.MemberDTO;
import com.project.apa.mapper.AuthMapper;

@Repository
public class AuthDAOImpl implements AuthDAO {

	@Autowired
	private AuthMapper mapper;
		
}
