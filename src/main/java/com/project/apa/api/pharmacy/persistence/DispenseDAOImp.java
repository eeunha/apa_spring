package com.project.apa.api.pharmacy.persistence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.apa.api.pharmacy.domain.DispenseCntDTO;
import com.project.apa.api.pharmacy.domain.DispenseDTO;
import com.project.apa.mapper.PharmacyMapper;

@Repository
public class DispenseDAOImp implements DispenseDAO {
	Logger logger = Logger.getLogger(this.getClass().getName());
    @Autowired
    private PharmacyMapper pharmacyMapper;


	@Override
	public List<DispenseDTO> getDispenseList(String id,int begin,int end) {
		Map<String, Object> input = new HashMap();
		input.put("id", id);
		input.put("begin", String.valueOf(begin));
		input.put("end", String.valueOf(end));
		logger.info("dbioInput=>"+input);
		
		return pharmacyMapper.getDispenseList(input);
	}
	

	
	
	@Override
	public List<DispenseDTO> getDispenseWaiting(String id, int begin, int end) {
		
		Map<String, Object> input = new HashMap();
		input.put("id", id);
		input.put("begin", String.valueOf(begin));
		input.put("end", String.valueOf(end));
		logger.info("dbioInput=>"+input);
		
		return pharmacyMapper.getDispenseWaiting(input);
	}
	
	@Override
	public List<DispenseDTO> getDispensing(String id, int begin, int end) {
		Map<String, Object> input = new HashMap();
		input.put("id", id);
		input.put("begin", String.valueOf(begin));
		input.put("end", String.valueOf(end));
		logger.info("dbioInput=>"+input);
		return pharmacyMapper.getDispensing(input);
	}
	
	@Override
	public List<DispenseDTO> getDispenseComplete(String id, int begin, int end) {
		Map<String, Object> input = new HashMap();
		input.put("id", id);
		input.put("begin", String.valueOf(begin));
		input.put("end", String.valueOf(end));
		logger.info("dbioInput=>"+input);
		return pharmacyMapper.getDispenseComplete(input);
	}
	
	@Override
	public List<DispenseDTO> getDispensePickUp(String id, int begin, int end) {
		Map<String, Object> input = new HashMap();
		input.put("id", id);
		input.put("begin", String.valueOf(begin));
		input.put("end", String.valueOf(end));
		logger.info("dbioInput=>"+input);
		return pharmacyMapper.getDispensePickUp(input);
	}

	@Override
	public DispenseCntDTO getCountByStatus(String id) {
		return pharmacyMapper.getCountByStatus(id);
	}
	
	@Override
	public boolean approveDispense(List<Integer> dispenseIds) {
		return pharmacyMapper.approveDispense(dispenseIds);
	}
	
	@Override
	public boolean rejectDispense(List<Integer> dispenseIds) {
		return pharmacyMapper.rejectDispense(dispenseIds);
	}
	
	@Override
	public boolean finishDispense(List<Integer> dispenseIds) {
		return pharmacyMapper.finishDispense(dispenseIds);
	}
	
	@Override
	public boolean pickUpFinishDispense(List<Integer> dispenseIds) {
		return pharmacyMapper.pickUpFinishDispense(dispenseIds);
	}
	
}
