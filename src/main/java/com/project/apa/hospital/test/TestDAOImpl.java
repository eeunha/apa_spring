package com.project.apa.hospital.test;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TestDAOImpl implements TestDAO {
	
	@Autowired
	private SqlSessionTemplate template;
	
	@Override
	public List<TestDTO> list() {
		return template.selectList("sample.list");
	}
}
