package com.project.apa.api.admin.persistence;

import java.util.List;

import com.project.apa.api.admin.domain.MemberDTO;

public interface AdminMemberDAO {

	List<MemberDTO> userInfo();

	List<MemberDTO> hospitalInfo();

	List<MemberDTO> pharmacyInfo();

}
