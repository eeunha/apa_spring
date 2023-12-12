package com.project.apa.api.search;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.apa.api.search.model.BookMarkDTO;
import com.project.apa.api.search.model.FindHospitalDTO;
import com.project.apa.api.search.model.HospitalInfoDTO;
import com.project.apa.api.search.model.SelfsymtomDTO;
import com.project.apa.api.search.service.SearchService;

@RestController
@RequestMapping("/search")
public class RestSearchController {

	@Autowired
	private SearchService service;

	
	@PostMapping(value = "/tagfind")
	public List<HospitalInfoDTO> tagfind(@RequestBody FindHospitalDTO dto) {

		List<String> findsystomlist = service.findsystomlist(dto);
		List<HospitalInfoDTO> list = null;
		if (findsystomlist.isEmpty()) {		
			list = service.findHospitalList2(dto.getDeptseq());
		} else {
			list = service.findHospitalList(findsystomlist);
		}
		return list;
	}
	
	@PostMapping(value = "/deptfind")
	public List<SelfsymtomDTO> deptfind(@RequestBody HospitalInfoDTO dto) {
		System.out.println(dto.getHospitalid());
		return service.finddept(dto);
	}

	@PostMapping(value = "/bookmark")
	public int bookmark(@RequestBody BookMarkDTO dto) {

		return service.bookmarkin(dto);
	}

	@PostMapping(value = "/bookmarkout")
	public int bookmarkout(@RequestBody BookMarkDTO dto) {

		return service.bookmarkout(dto);
	}
}
