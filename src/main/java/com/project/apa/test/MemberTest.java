package com.project.apa.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.project.apa.auth.model.AuthDTO;
import com.project.apa.auth.model.MemberDTO;
import com.project.apa.mapper.AuthMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml","file:src/main/webapp/WEB-INF/spring/security-context.xml"})
public class MemberTest {

	
	  @Autowired private AuthMapper mapper;
	  
	  @Autowired private PasswordEncoder encoder;
	  
	  @Test
	  public void testInsertMember() {
	  List<MemberDTO> list = mapper.mymy();
	  for (MemberDTO dto : list) {
		  dto.setUserpw(encoder.encode(dto.getUserpw()));
		  mapper.encode(dto); 
		  }
	  }
	 
	
}
