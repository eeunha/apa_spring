package com.project.apa.api.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.apa.api.user.domain.UserDTO;
import com.project.apa.api.user.domain.UserDetailRecordDTO;
import com.project.apa.api.user.domain.UserRecordDTO;
import com.project.apa.api.user.domain.UserReviewDTO;
import com.project.apa.api.user.domain.UserAppointmentDTO;
import com.project.apa.api.user.domain.UserBookmarkDTO;
import com.project.apa.api.user.domain.UserChildDTO;
import com.project.apa.api.user.persistence.UserDAO;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;
	
	@Override
	public UserDTO getUser(String seq) {

		return userDAO.getUser(seq);
	}
	
	@Override
	public int editUser(UserDTO dto) {

		return userDAO.editUser(dto);
	}
	
	@Override
	public int deleteUser(String seq) {

		return userDAO.deleteUser(seq);
	}

	@Override
	public List<UserChildDTO> getChild(String seq) {

		return userDAO.getChild(seq);
	}
	
	@Override
	public int editChild(UserChildDTO dto) {

		return userDAO.editChild(dto);
	}
	
	@Override
	public int deleteChild(String seq) {

		return userDAO.deleteChild(seq);
	}
	
	@Override
	public int addChild(UserChildDTO dto) {

		return userDAO.addChild(dto);
	}
	
	@Override
	public int addFirstChild(UserChildDTO dto) {

		return userDAO.addFirstChild(dto);
	}
	
	@Override
	public List<UserAppointmentDTO> getUserAppointment(String seq) {

		return userDAO.getUserAppointment(seq);
	}
	
	@Override
	public List<UserRecordDTO> getUserRecord(String seq) {

		return userDAO.getUserRecord(seq);
	}
	
	@Override
	public UserDetailRecordDTO getUserDetailRecord(String seq) {

		return userDAO.getUserDetailRecord(seq);
	}
	
	@Override
	public UserReviewDTO insertReview(String seq) {

		return userDAO.insertReview(seq);
	}
	
	@Override
	public int insertReviewOK(UserReviewDTO dto) {

		return userDAO.insertReviewOK(dto);
	}
	
	@Override
	public int getLastReviewSeq() {
		
		return userDAO.getLastReviewSeq();
	}

	@Override
	public int insertTag(UserReviewDTO dto) {

		return userDAO.insertTag(dto);
	}
	
	@Override
	public List<UserBookmarkDTO> getUserBookmark(String seq) {

		return userDAO.getUserBookmark(seq);
	}
	
	@Override
	public int deleteBookmark(String seq) {

		return userDAO.deleteBookmark(seq);
	}
}
