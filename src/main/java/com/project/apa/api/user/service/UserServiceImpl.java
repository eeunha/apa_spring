package com.project.apa.api.user.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.apa.api.user.domain.UserDTO;
import com.project.apa.api.user.domain.UserDetailRecordDTO;
import com.project.apa.api.user.domain.UserMediCounselQuestionDTO;
import com.project.apa.api.user.domain.UserMediTestDTO;
import com.project.apa.api.user.domain.UserMyCommunityDTO;
import com.project.apa.api.user.domain.UserRecordDTO;
import com.project.apa.api.user.domain.UserReviewDTO;
import com.project.apa.api.user.domain.SelfTestDTO;
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
	
	@Override
	public List<UserMediTestDTO> getUserMediTest(String seq) {

		return userDAO.getUserMediTest(seq);
	}
	
	@Override
	public UserMediTestDTO getUserDetailMediTest(String seq) {
		
		return userDAO.getUserDetailMediTest(seq);
	}
	
	@Override
	public List<UserMediCounselQuestionDTO> getUserMyMediCounselQuestion(String seq) {

		return userDAO.getUserMyMediCounselQuestion(seq);
	}
	
	@Override
	public UserMediCounselQuestionDTO getUserMyMediCounselQuestionDetail(String seq) {

		return userDAO.getUserMyMediCounselQuestionDetail(seq);
	}
	
	@Override
	public int deleteMyCounselBox(String aseq) {

		return userDAO.deleteMyCounselBox(aseq);
	}
	
	@Override
	public int deleteMyCounselAnswer(String qseq) {

		return userDAO.deleteMyCounselAnswer(qseq);
	}
	
	@Override
	public int deleteMyCounselQuestion(String qseq) {

		return userDAO.deleteMyCounselQuestion(qseq);
	}
	
	@Override
	public List<UserMediCounselQuestionDTO> getUserEtcMediCounselQuestion(String seq) {

		return userDAO.getUserEtcMediCounselQuestion(seq);
	}
	
	@Override
	public UserMediCounselQuestionDTO getUserEtcMediCounselQuestionDetail(String seq) {

		return userDAO.getUserEtcMediCounselQuestionDetail(seq);
	}
	
	@Override
	public int deleteEtcCounselQuestion(String seq) {

		return userDAO.deleteEtcCounselQuestion(seq);
	}
	
	@Override
	public List<UserMyCommunityDTO> getUserMyCommunity(String seq) {

		return userDAO.getUserMyCommunity(seq);
	}
	
	@Override
	public UserMyCommunityDTO getUserMyCommunityDetail(String seq) {

		return userDAO.getUserMyCommunityDetail(seq);
	}
	
	@Override
	public List<UserMyCommunityDTO> getUserMyCommunityComment(String seq) {

		return userDAO.getUserMyCommunityComment(seq);
	}
	
	@Override
	public int userCommunityUpdate(UserMyCommunityDTO dto) {

		return userDAO.userCommunityUpdate(dto);
	}
	
	@Override
	public int deleteCommunityComment(String seq) {

		return userDAO.deleteCommunityComment(seq);
	}
	
	@Override
	public int deleteCommunity(String seq) {

		return userDAO.deleteCommunity(seq);
	}
	
	@Override
	public List<UserReviewDTO> getUserReview(String seq) {
		
		return userDAO.getUserReview(seq);
	}
	
	@Override
	public UserReviewDTO getUserReviewDetail(String seq) {

		return userDAO.getUserReviewDetail(seq);
	}
	
	@Override
	public List<UserReviewDTO> getUserReviewDetailTag(String seq) {

		return userDAO.getUserReviewDetailTag(seq);
	}
	
	@Override
	public int deleteReview(String seq) {

		return userDAO.deleteReview(seq);
	}

	@Override
	public List<SelfTestDTO> getSelfTest(String seq) {

		return userDAO.getSelfTest(seq);
	}
	
	@Override
	public ArrayList<String> getSelfTestAnswer(String meditestQuestionNo) {

		return userDAO.getSelfTestAnswer(meditestQuestionNo);
	}
	
	@Override
	public String getSelfTestMinQuestionSeq(String seq) {

		return userDAO.getSelfTestMinQuestionSeq(seq);
	}
	
	@Override
	public List<SelfTestDTO> getSelfTestAnswerContent(String seq) {

		return userDAO.getSelfTestAnswerContent(seq);
	}
	
	@Override
	public List<SelfTestDTO> getSelfTestResult(String seq) {
		
		return userDAO.getSelfTestResult(seq);
	}
	
	@Override
	public int saveTestResult(SelfTestDTO dto) {

		return userDAO.saveTestResult(dto);
	}
}
