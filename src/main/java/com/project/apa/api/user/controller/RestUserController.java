package com.project.apa.api.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.apa.api.user.domain.UserAppointmentDTO;
import com.project.apa.api.user.domain.UserBookmarkDTO;
import com.project.apa.api.user.domain.UserChildDTO;
import com.project.apa.api.user.domain.UserDTO;
import com.project.apa.api.user.domain.UserDetailRecordDTO;
import com.project.apa.api.user.domain.UserRecordDTO;
import com.project.apa.api.user.domain.UserReviewDTO;
import com.project.apa.api.user.service.UserService;

@RestController
public class RestUserController {

	@Autowired
	private UserService userService;
	
	
	//내 정보 조회
	@GetMapping(value="/api/user/{seq}/mypage")
	public UserDTO getUser(@PathVariable String seq) {

		//seq = "1";
		
		UserDTO dto = userService.getUser(seq);

		String[] ssnArr = dto.getUserSSN().split("-");
		
		dto.setUserSSNs(ssnArr[0]);
		dto.setUserSSNe(ssnArr[1]);
		
		String[] telArr = dto.getUserTel().split("-");
		
		dto.setUserTels(telArr[0]);
		dto.setUserTelm(telArr[1]);
		dto.setUserTele(telArr[2]);
		
		dto.setMaskingSSN(ssnArr[1].charAt(0) + "******");
		
		return dto;
	}
	
	//내 정보 수정
	@PutMapping(value="/api/user/{seq}/mypage")
	public int editUser(@RequestBody UserDTO dto, @PathVariable("seq") String seq) {
		
		String tel = dto.getUserTels() + "-" + dto.getUserTelm() + "-" + dto.getUserTele();
		
		dto.setUserTel(tel);
		
		return userService.editUser(dto);
	}
	
	//회원 탈퇴
	@PatchMapping(value="/api/user/{seq}/mypage")
	public int deleteUser(@PathVariable("seq") String seq) {
		
		return userService.deleteUser(seq);
	}
	
	//자녀 목록 조회
	@GetMapping(value = "/api/user/{seq}/mychild")
	public List<UserChildDTO> myChild(@PathVariable("seq") String seq) {
		
		List<UserChildDTO> userChildList = userService.getChild(seq);
		
		for (UserChildDTO dto : userChildList) {
			String cSSN[] = dto.getChildSSN().split("-");
			
			dto.setChildSSNs(cSSN[0]);
			dto.setChildSSNe(cSSN[1].charAt(0) + "******");
		}
		
		return userChildList;
	}
	
	//자녀 이름 수정
	@PutMapping(value = "/api/user/{seq}/mychild")
	public int editChild(@RequestBody UserChildDTO dto, @PathVariable("seq") String seq) {
		
		dto.setChildSeq(seq);
		
		return userService.editChild(dto);
	}	

	//자녀 삭제
	@PatchMapping(value="/api/user/{seq}/mychild")
	public int deleteChild(@PathVariable("seq") String seq) {
		
		return userService.deleteChild(seq);
	}	
	
	//자녀 등록
	@PostMapping(value="/api/user/{seq}/mychild")
	public int addChild(@RequestBody UserChildDTO dto, @PathVariable("seq") String seq) {
		
		dto.setUserSeq(seq);
		
		String childSSN = dto.getChildSSNs() + '-' + dto.getChildSSNe();
		
		dto.setChildSSN(childSSN);
		
		return userService.addChild(dto);
	}	
	
	//첫 자녀 등록
	@PostMapping(value="/api/user/{seq}/myfirstchild")
	public int addFirstChild(@RequestBody UserChildDTO dto, @PathVariable("seq") String seq) {
		
		dto.setUserSeq(seq);
		
		String childSSN = dto.getChildSSNs() + '-' + dto.getChildSSNe();
		
		dto.setChildSSN(childSSN);
		
		userService.addFirstChild(dto);
		
		return userService.addChild(dto);
	}
	
	//예약 진료 목록 조회
	@GetMapping(value = "/api/user/{seq}/mymedi/appointment")
	public List<UserAppointmentDTO> myappointment(@PathVariable("seq") String seq) {
		
		return userService.getUserAppointment(seq);
	}
	
	//진료 내역 조회
	@GetMapping(value = "/api/user/{seq}/mymedi/record")
	public List<UserRecordDTO> myrecord(@PathVariable("seq") String seq) {
		
		return userService.getUserRecord(seq);
	}
	
	//진료 내역 상세 보기
	@GetMapping(value = "/api/user/{seq}/mymedi/detailrecord")
	public UserDetailRecordDTO detailrecord(@PathVariable("seq") String seq) {

		return userService.getUserDetailRecord(seq);
	}
	
	//리뷰 작성 (정보 조회)
	@GetMapping(value = "/api/user/{seq}/mymedi/insertreview")
	public UserReviewDTO insertreview(@PathVariable("seq") String seq) {
		
		return userService.insertReview(seq);
	}
	
	//리뷰 작성
	@PostMapping(value = "/api/user/{seq}/mymedi/insertreviewok")
	public int insertreviewok(@RequestBody UserReviewDTO dto ,@PathVariable("seq") String seq) {

		dto.setAppointmentSeq(seq);
		
		int result = userService.insertReviewOK(dto);
		
		int rseq = userService.getLastReviewSeq();
		
		dto.setReviewSeq(rseq + "");
		
		String tag[] = dto.getTagList().split(",");
		
		for (int i=0; i<tag.length; i++) {
			dto.setTagSeq(tag[i]);
			result = userService.insertTag(dto);			
		}			
		
		return result;
	}

	//즐겨찾기 병원 조회
	@GetMapping(value = "/api/user/{seq}/mybookmark")
	public List<UserBookmarkDTO> mybookmark(@PathVariable("seq") String seq) {
		
		return userService.getUserBookmark(seq);
	}
	
	//즐겨찾기 병원 삭제
	@DeleteMapping(value = "/api/user/{seq}/mybookmark")
	public int deletebookmark(@PathVariable("seq") String seq) {
		
		return userService.deleteBookmark(seq);
	}
	
}
