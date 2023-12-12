package com.project.apa.api.user.persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.apa.api.user.domain.UserDTO;
import com.project.apa.api.user.domain.UserDetailRecordDTO;
import com.project.apa.api.user.domain.UserRecordDTO;
import com.project.apa.api.user.domain.UserReviewDTO;
import com.project.apa.api.user.domain.UserAppointmentDTO;
import com.project.apa.api.user.domain.UserBookmarkDTO;
import com.project.apa.api.user.domain.UserChildDTO;
import com.project.apa.mapper.UserMapper;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public UserDTO getUser(String seq) {

		return userMapper.getUser(seq);
	}
	
	@Override
	public int editUser(UserDTO dto) {

		return userMapper.editUser(dto);
	}
	
	@Override
	public int deleteUser(String seq) {

		return userMapper.deleteUser(seq);
	}
	
	@Override
	public List<UserChildDTO> getChild(String seq) {

		return userMapper.getChild(seq);
	}
	
	@Override
	public int editChild(UserChildDTO dto) {

		return userMapper.editChild(dto);
	}
	
	@Override
	public int deleteChild(String seq) {
		
		return userMapper.deleteChild(seq);
	}
	
	@Override
	public int addChild(UserChildDTO dto) {

		return userMapper.addChild(dto);
	}
	
	@Override
	public int addFirstChild(UserChildDTO dto) {
		
		return userMapper.addFirstChild(dto);
	}
	
	@Override
	public List<UserAppointmentDTO> getUserAppointment(String seq) {

		return userMapper.getUserAppointment(seq);
	}
	
	@Override
	public List<UserRecordDTO> getUserRecord(String seq) {

		return userMapper.getUserRecord(seq);
	}
	
	@Override
	public UserDetailRecordDTO getUserDetailRecord(String seq) {

		return userMapper.getUserDetailRecord(seq);
	}
	
	@Override
	public UserReviewDTO insertReview(String seq) {
		
		return userMapper.insertReview(seq);
	}
	
	@Override
	public int insertReviewOK(UserReviewDTO dto) {

		return userMapper.insertReviewOK(dto);
	}
	
	@Override
	public int getLastReviewSeq() {

		return userMapper.getLastReviewSeq();
	}
	
	@Override
	public int insertTag(UserReviewDTO dto) {
		
		return userMapper.insertTag(dto);
	}
	
	@Override
	public List<UserBookmarkDTO> getUserBookmark(String seq) {

		return userMapper.getUserBookmark(seq);
	}
	
	@Override
	public int deleteBookmark(String seq) {

		return userMapper.deleteBookmark(seq);
	}
}
