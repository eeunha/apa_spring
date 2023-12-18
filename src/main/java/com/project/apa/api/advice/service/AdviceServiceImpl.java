package com.project.apa.api.advice.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.apa.api.advice.domain.AdviceDTO;
import com.project.apa.api.advice.domain.StorageDTO;
import com.project.apa.api.advice.persistence.AdviceDAO;import com.project.apa.mapper.AdviceMapper;


@Service
public class AdviceServiceImpl implements AdviceService {
	
	@Autowired
	private AdviceDAO adviceDAO;
	/*
	@Autowired
	private AdviceMapper adviceMapper;
	*/

	public List<AdviceDTO> getAdviceList(HashMap<String, Integer> map) {
		
		//System.out.println(map.toString());
		return adviceDAO.getAdviceList(map);
	}
	@Override
	public List<AdviceDTO> getDepartmentList() {
		return adviceDAO.getDepartmentList();
	}

	@Override
	public List<AdviceDTO> findlist(AdviceDTO dto) {
		return adviceDAO.findlist(dto);
	}
	

	@Override
	public int storage(StorageDTO dto) {
		
		return adviceDAO.storage(dto);
	}

}
