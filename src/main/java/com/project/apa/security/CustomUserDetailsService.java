package com.project.apa.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.project.apa.auth.model.AdminMemberDTO;
import com.project.apa.auth.model.CustomUser;
import com.project.apa.auth.model.HospitalMemberDTO;
import com.project.apa.auth.model.MemberDTO;
import com.project.apa.auth.model.PharmacyMemberDTO;
import com.project.apa.mapper.AuthMapper;

public class CustomUserDetailsService implements UserDetailsService{

	   @Autowired
	   private AuthMapper mapper;
	   
	   @Override
	   public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	      
		  System.out.println(username);
		   
	      //DB 상에서 회원 정보 읽어서 > 인증 객체 대입
	      //username == 아이디
		   
		  String sel = username.substring(0, 1); //1,2,3
		  username = username.substring(1);
		  
		  if (sel.equals("1") || sel.equals("0")) {
			  AdminMemberDTO dto4 = mapper.adminread(username);
			  MemberDTO dto1 = mapper.read(username);
			  System.out.println("안녕" );
			//MemberDTO > 시큐리티에서 사용(변환) > CustomUser
			  
			  System.out.println(dto4 == null);
			  System.out.println(dto1 ==  null);
//			  
			  if(dto1 != null) {
//		      return dto1 != null ? new CustomUser(dto1) : null;

				  System.out.println(dto1.getUserpw());
				  return new CustomUser(dto1);
			  } 
			  else if (dto4 != null) {

//		      return dto4 != null ? new CustomUser(dto4) : null;
				  return new CustomUser(dto4);
			  }
			  
		  } else if (sel.equals("2")) {
			  HospitalMemberDTO dto2 = mapper.hospitalread(username);
			//MemberDTO > 시큐리티에서 사용(변환) > CustomUser
		      return dto2 != null ? new CustomUser(dto2) : null;
		      
		  } else {
			  PharmacyMemberDTO dto3 = mapper.pharmacyread(username);
			//MemberDTO > 시큐리티에서 사용(변환) > CustomUser
		      return dto3 != null ? new CustomUser(dto3) : null;
		  }
		  
		  return null;
	}
	   
	  
}