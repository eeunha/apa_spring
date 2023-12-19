package com.project.apa.api.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.apa.api.admin.domain.AfterDTO;
import com.project.apa.api.admin.domain.BlackDTO;
import com.project.apa.api.admin.domain.ReportDTO;
import com.project.apa.api.admin.service.AdminService;

@RestController
@RequestMapping("/admin")
public class RestAdminController {

	@Autowired
	private AdminService service;
	
	@PostMapping(value = "/blacklistadd")
	public int blacklistadd(@RequestBody BlackDTO dto) {
		
		return service.blacklistadd(dto);
	}
	
	@PostMapping(value = "/blacklistdel")
	public int blacklistdel(@RequestBody BlackDTO dto) {
		
		return service.blacklistdel(dto);
	}
	
	@PostMapping(value = "/afteredit")
	public int afteredit(@RequestBody AfterDTO dto) {
		return service.afteredit(dto);
	}
	
	@PostMapping(value = "/postreportdecline")
	public int postreportdecline(@RequestBody ReportDTO dto) {
		return service.postreportdecline(dto);
	}
	
	@PostMapping(value = "/postreportapprove")
	public int postreportapprove(@RequestBody ReportDTO dto) {
		return service.postreportapprove(dto);
	}
	
	@PostMapping(value = "/postprivate")
	public int postprivate(@RequestBody ReportDTO dto) {
		return service.postprivate(dto);
	}
	
	@PostMapping(value = "/cautionAdd")
	public int cautionAdd(@RequestBody ReportDTO dto) {
		return service.cautionAdd(dto);
	}
	
	@PostMapping(value = "/commentreportapprove")
	public int commentreportapprove(@RequestBody ReportDTO dto) {
		
		//System.out.println(dto.getCommentReportSeq());
		
		return service.commentreportapprove(dto);
	}
	
	@PostMapping(value = "/commentreportdecline")
	public int commentreportdecline(@RequestBody ReportDTO dto) {
		return service.commentreportdecline(dto);
	}
	
}
