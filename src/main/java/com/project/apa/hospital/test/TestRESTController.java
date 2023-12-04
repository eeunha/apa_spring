package com.project.apa.hospital.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRESTController {

	@Autowired
	private TestDAO dao;

	@GetMapping(value = "/test")
	public List<TestDTO> list() {
		return dao.list();
	}
}
