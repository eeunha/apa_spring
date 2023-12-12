package com.project.apa.api.user.persistence;

import java.util.List;

import com.project.apa.api.user.domain.UserDTO;
import com.project.apa.api.user.domain.UserDetailRecordDTO;
import com.project.apa.api.user.domain.UserRecordDTO;
import com.project.apa.api.user.domain.UserReviewDTO;
import com.project.apa.api.user.domain.UserAppointmentDTO;
import com.project.apa.api.user.domain.UserBookmarkDTO;
import com.project.apa.api.user.domain.UserChildDTO;

public interface UserDAO {

	UserDTO getUser(String seq);

	int editUser(UserDTO dto);

	int deleteUser(String seq);

	List<UserChildDTO> getChild(String seq);

	int editChild(UserChildDTO dto);

	int deleteChild(String seq);

	int addChild(UserChildDTO dto);

	int addFirstChild(UserChildDTO dto);

	List<UserAppointmentDTO> getUserAppointment(String seq);

	List<UserRecordDTO> getUserRecord(String seq);

	UserDetailRecordDTO getUserDetailRecord(String seq);

	UserReviewDTO insertReview(String seq);

	int insertReviewOK(UserReviewDTO dto);

	int getLastReviewSeq();

	int insertTag(UserReviewDTO dto);

	List<UserBookmarkDTO> getUserBookmark(String seq);

	int deleteBookmark(String seq);
	
}
