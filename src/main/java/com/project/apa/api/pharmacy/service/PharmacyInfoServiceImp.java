package com.project.apa.api.pharmacy.service;

import com.project.apa.api.pharmacy.domain.PharmacyInfoDTO;
import com.project.apa.api.pharmacy.persistence.PharmacyInfoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PharmacyInfoServiceImp implements PharmacyInfoService {

    @Autowired
    private PharmacyInfoDAO pharmacyInfoDAO;

    @Override
    public PharmacyInfoDTO getPharmacyInfo(String id) {
        return pharmacyInfoDAO.getPharmacyInfo(id);
    }
    
    @Override
    public PharmacyInfoDTO getPharmacyOpeningInfo(String id) {
    	
    	return pharmacyInfoDAO.getPharmacyOpeningInfo(id);
    }
    
}
