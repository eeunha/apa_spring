package com.project.apa.api.pharmacy.persistence;

import com.project.apa.api.pharmacy.domain.PharmacyInfoDTO;
import com.project.apa.mapper.PharmacyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PharmacyInfoDAOImp implements PharmacyInfoDAO {

    @Autowired
    private PharmacyMapper pharmacyMapper;

    @Override
    public PharmacyInfoDTO getPharmacyInfo(String id) {
        return pharmacyMapper.getPharmacyInfo(id);
    }
    
    @Override
    public PharmacyInfoDTO getPharmacyOpeningInfo(String id) {
    	return pharmacyMapper.getPharmacyOpeningInfo(id);
    }
}
