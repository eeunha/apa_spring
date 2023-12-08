package com.project.apa.auth.model;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Getter;

@Getter
public class CustomUser extends User{

	private MemberDTO dto;
	
	public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}
	
	public CustomUser(MemberDTO dto) {
		super(dto.getUserid(), dto.getUserpw(), dto.getAuthlist().stream()
				.map(auth -> new SimpleGrantedAuthority(auth.getUserauth())).collect(Collectors.toList()));
		this.dto= dto;
	}	

	
	
}
