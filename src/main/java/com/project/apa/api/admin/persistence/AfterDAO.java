package com.project.apa.api.admin.persistence;

import java.util.List;

import com.project.apa.api.admin.domain.AfterDTO;

public interface AfterDAO {

	List<AfterDTO> afterlist();

	List<AfterDTO> afterview(String hospitalId);

	int afteredit(AfterDTO dto);

}
