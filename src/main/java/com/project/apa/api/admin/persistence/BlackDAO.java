package com.project.apa.api.admin.persistence;

import java.util.List;

import com.project.apa.api.admin.domain.BlackDTO;

public interface BlackDAO {

	List<BlackDTO> blacklist();
	
	int blacklistadd(BlackDTO dto);

	int blacklistdel(BlackDTO dto);


}
