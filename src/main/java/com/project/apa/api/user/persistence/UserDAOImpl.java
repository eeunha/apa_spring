package com.project.apa.api.user.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
	
	@Override
	public List<UserMediTestDTO> getUserMediTest(String seq) {

		return userMapper.getUserMediTest(seq);
	}
	
	@Override
	public UserMediTestDTO getUserDetailMediTest(String seq) {
		
		return userMapper.getUserDetailMediTest(seq);
	}
	
	@Override
	public List<UserMediCounselQuestionDTO> getUserMyMediCounselQuestion(String seq) {

		return userMapper.getUserMyMediCounselQuestion(seq);
	}
	
	@Override
	public UserMediCounselQuestionDTO getUserMyMediCounselQuestionDetail(String seq) {

		return userMapper.getUserMyMediCounselQuestionDetail(seq);
	}
	
	@Override
	public int deleteMyCounselBox(String aseq) {

		return userMapper.deleteMyCounselBox(aseq);
	}
	
	@Override
	public int deleteMyCounselAnswer(String qseq) {
		
		return userMapper.deleteMyCounselAnswer(qseq);
	}
	
	@Override
	public int deleteMyCounselQuestion(String qseq) {
		
		return userMapper.deleteMyCounselQuestion(qseq);
	}
	
	@Override
	public List<UserMediCounselQuestionDTO> getUserEtcMediCounselQuestion(String seq) {

		return userMapper.getUserEtcMediCounselQuestion(seq);
	}
	
	@Override
	public UserMediCounselQuestionDTO getUserEtcMediCounselQuestionDetail(String seq) {

		return userMapper.getUserEtcMediCounselQuestionDetail(seq);
	}
	
	@Override
	public int deleteEtcCounselQuestion(String seq) {

		return userMapper.deleteEtcCounselQuestion(seq);
	}
	
	@Override
	public List<UserMyCommunityDTO> getUserMyCommunity(String seq) {

		return userMapper.getUserMyCommunity(seq);
	}
	
	@Override
	public UserMyCommunityDTO getUserMyCommunityDetail(String seq) {

		return userMapper.getUserMyCommunityDetail(seq);
	}
	
	@Override
	public List<UserMyCommunityDTO> getUserMyCommunityComment(String seq) {

		return userMapper.getUserMyCommunityComment(seq);
	}
	
	@Override
	public int userCommunityUpdate(UserMyCommunityDTO dto) {

		return userMapper.userCommunityUpdate(dto);
	}
	
	@Override
	public int deleteCommunityComment(String seq) {

		return userMapper.deleteCommunityComment(seq);
	}
	
	@Override
	public int deleteCommunity(String seq) {
		
		return userMapper.deleteCommunity(seq);
	}
	
	@Override
	public List<UserReviewDTO> getUserReview(String seq) {
		
		return userMapper.getUserReview(seq);
	}
	
	@Override
	public UserReviewDTO getUserReviewDetail(String seq) {
		
		return userMapper.getUserReviewDetail(seq);
	}
	
	@Override
	public List<UserReviewDTO> getUserReviewDetailTag(String seq) {
		
		return userMapper.getUserReviewDetailTag(seq);
	}
	
	@Override
	public int deleteReview(String seq) {

		return userMapper.deleteReview(seq);
	}
	
	@Override
	public List<SelfTestDTO> getSelfTest(String seq) {
		
		return userMapper.getSelfTest(seq);
	}
	
	@Override
	public ArrayList<String> getSelfTestAnswer(String meditestQuestionNo) {

		return userMapper.getSelfTestAnswer(meditestQuestionNo);
	}

	@Override
	public String getSelfTestMinQuestionSeq(String seq) {

		return userMapper.getSelfTestMinQuestionSeq(seq);
	}
	
	@Override
	public List<SelfTestDTO> getSelfTestAnswerContent(String seq) {
		
		return userMapper.getSelfTestAnswerContent(seq);
	}
	
	@Override
	public List<SelfTestDTO> getSelfTestResult(String seq) {
		
		return userMapper.getSelfTestResult(seq);
	}
	
	@Override
	public int saveTestResult(SelfTestDTO dto) {

		return userMapper.saveTestResult(dto);
	}
	
}
