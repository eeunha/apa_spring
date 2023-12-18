package com.project.apa.api.community.persistence;


import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.apa.api.community.domain.CommunityCommentDTO;
import com.project.apa.api.community.domain.CommunityDTO;
import com.project.apa.mapper.CommunityMapper;

@Repository
public class CommunityDAOImpl implements CommunityDAO {
	
	@Autowired
	private CommunityMapper communityMapper;
	
	@Override
	public List<CommunityDTO> getCommunityList(HashMap<String, Integer> map) {
		
		return communityMapper.getCommunityList(map);
	}

	@Override
	public CommunityDTO getCommunityInfo(String seq) {
		
		return communityMapper.getCommunityInfo(seq);
	}
	
	@Override
	public List<CommunityCommentDTO> getCommentList(String seq) {
		return communityMapper.getCommentList(seq);
	}

	
	@Override
	public int commentadd(CommunityCommentDTO dto) {
		
		return communityMapper.commentadd(dto);
	}
	
	@Override
	public int commentdel(CommunityCommentDTO dto) {
		
		return communityMapper.commentdel(dto);
	}
	
	@Override
	public int getTotalCount() {
		
		return communityMapper.getTotalCount();
	}
	
	@Override
	public List<CommunityDTO> getCommunityAdd() {
		
		return communityMapper.getCommunityAdd();
	}
	@Override
	public int add(CommunityDTO dto) {
		
		return communityMapper.add(dto);
	}
	
	
}
