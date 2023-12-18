package com.project.apa.api.community.service;


import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.apa.api.community.domain.CommunityCommentDTO;
import com.project.apa.api.community.domain.CommunityDTO;
import com.project.apa.api.community.persistence.CommunityDAO;

@Service
public class CommunityService {
	
	@Autowired
	private CommunityDAO communitydao;

	public List<CommunityDTO> getCommunityList(HashMap<String, Integer> map) {
		
		return communitydao.getCommunityList(map);
	}

	public CommunityDTO getCommunityInfo(String seq) {
		
		return communitydao.getCommunityInfo(seq);
	}

	public List<CommunityCommentDTO> getCommentList(String seq) {
		
		return communitydao.getCommentList(seq);
	}


	public int commentadd(CommunityCommentDTO dto) {
		
		return communitydao.commentadd(dto);
	}

	public int commentdel(CommunityCommentDTO dto) {
		
		return communitydao.commentdel(dto);
	}

	public int getTotalCount() {
		
		return communitydao.getTotalCount();
	}

	public List<CommunityDTO> getCommunityAdd() {
		
		return communitydao.getCommunityAdd();
	}

	public int add(CommunityDTO dto) {
		
		return communitydao.add(dto);
	}


	
}
