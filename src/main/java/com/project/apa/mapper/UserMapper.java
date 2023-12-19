package com.project.apa.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

public interface UserMapper {

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

	List<UserMediTestDTO> getUserMediTest(String seq);

	UserMediTestDTO getUserDetailMediTest(String seq);

	List<UserMediCounselQuestionDTO> getUserMyMediCounselQuestion(String seq);

	UserMediCounselQuestionDTO getUserMyMediCounselQuestionDetail(String seq);

	int deleteMyCounselBox(String aseq);

	int deleteMyCounselAnswer(String qseq);

	int deleteMyCounselQuestion(String qseq);

	List<UserMediCounselQuestionDTO> getUserEtcMediCounselQuestion(String seq);

	UserMediCounselQuestionDTO getUserEtcMediCounselQuestionDetail(String seq);

	int deleteEtcCounselQuestion(String seq);

	List<UserMyCommunityDTO> getUserMyCommunity(String seq);

	UserMyCommunityDTO getUserMyCommunityDetail(String seq);

	List<UserMyCommunityDTO> getUserMyCommunityComment(String seq);

	int userCommunityUpdate(UserMyCommunityDTO dto);

	int deleteCommunityComment(String seq);

	int deleteCommunity(String seq);

	List<UserReviewDTO> getUserReview(String seq);

	UserReviewDTO getUserReviewDetail(String seq);

	List<UserReviewDTO> getUserReviewDetailTag(String seq);

	int deleteReview(String seq);

	List<SelfTestDTO> getSelfTest(String seq);

	ArrayList<String> getSelfTestAnswer(String meditestQuestionNo);

	List<SelfTestDTO> getSelfTestAnswerContent(String seq);

	String getSelfTestMinQuestionSeq(String seq);

	List<SelfTestDTO> getSelfTestResult(String seq);

	int saveTestResult(SelfTestDTO dto);

	String getUserSeq(String id);
	
}
