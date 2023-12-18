package com.project.apa.api.advice.persistence;


import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.apa.api.advice.domain.AdviceDTO;
import com.project.apa.api.advice.domain.StorageDTO;
import com.project.apa.mapper.AdviceMapper;

@Repository
public class AdviceDAOImpl implements AdviceDAO {

	@Autowired
	private AdviceMapper adviceMapper;
	
	
	
	@Override
	public int add(AdviceDTO dto) {
		return adviceMapper.add(dto);
	}
	
	
	@Override
	public List<AdviceDTO> getAdviceList(HashMap<String, Integer> map) {
		return adviceMapper.getAdviceList(map);
	}

	@Override
	public List<AdviceDTO> getDepartmentList() {
		
		return adviceMapper.getDepartmentList();
	}
	@Override
	public int getTotalCount() {
		
		return adviceMapper.getTotalCount();
	}
	
	@Override
	public int storage(StorageDTO dto) {
		
		return adviceMapper.storage(dto);
	}


	@Override
	public List<AdviceDTO> findlist(AdviceDTO dto) {
		return adviceMapper.findlist(dto);
	}
	

}
