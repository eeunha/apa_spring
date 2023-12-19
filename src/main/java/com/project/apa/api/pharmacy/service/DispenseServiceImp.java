package com.project.apa.api.pharmacy.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.apa.api.pharmacy.domain.DispenseCntDTO;
import com.project.apa.api.pharmacy.domain.DispenseDTO;
import com.project.apa.api.pharmacy.persistence.DispenseDAO;
import com.project.apa.mapper.PharmacyMapper;

@Service
public class DispenseServiceImp implements DispenseService {

    @Autowired
    private DispenseDAO dispenseDAO;

    @Autowired
    public DispenseServiceImp(DispenseDAO dispenseDAO) {
        this.dispenseDAO = dispenseDAO;
    }
    

	@Override
	public List<DispenseDTO> getDispenseList(String id,int begin,int end) {
		return dispenseDAO.getDispenseList(id, begin, end);
	}


	@Override
	public List<DispenseDTO> getDispenseWaiting(String id, int begin, int end) {
		return dispenseDAO.getDispenseWaiting(id, begin, end);
	
	}
	
	@Override
	public List<DispenseDTO> getDispensing(String id, int begin, int end) {
		return dispenseDAO.getDispensing(id, begin, end);
	}
	
	@Override
	public List<DispenseDTO> getDispenseComplete(String id, int begin, int end) {
		
		return dispenseDAO.getDispenseComplete(id, begin, end);
	}
	
	@Override
	public List<DispenseDTO> getDispensePickUp(String id, int begin, int end) {
		// TODO Auto-generated method stub
		return dispenseDAO.getDispensePickUp(id, begin, end);
	}
	
	@Override
	public DispenseCntDTO getCountByStatus(String id) {
		// TODO Auto-generated method stub
		return dispenseDAO.getCountByStatus(id);
	}
	
	@Override
	public boolean approveDispense(List<Integer> dispenseIds) {
		// TODO Auto-generated method stub
		 return dispenseDAO.approveDispense(dispenseIds);
	}
	
	@Override
	public boolean rejectDispense(List<Integer> dispenseIds) {
		
		return dispenseDAO.rejectDispense(dispenseIds);
	}
	
	@Override
	public boolean finishDispense(List<Integer> dispenseIds) {

		return dispenseDAO.finishDispense(dispenseIds);
	}
	@Override
	public boolean pickUpFinishDispense(List<Integer> dispenseIds) {
		return dispenseDAO.pickUpFinishDispense(dispenseIds);
	}

	 
}
