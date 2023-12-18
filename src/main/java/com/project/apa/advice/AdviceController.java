package com.project.apa.advice;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.apa.api.advice.domain.AdviceDTO;
import com.project.apa.api.advice.persistence.AdviceDAO;
import com.project.apa.api.advice.service.AdviceService;

@Controller
public class AdviceController {

	@Autowired
	private AdviceDAO dao;

	@Autowired
	private AdviceService adviceservice;
	
	
	@GetMapping(value = "/advice/list.do")
	public String list(String page, Model model) {
		 
		 
		List<AdviceDTO> listDepartment = adviceservice.getDepartmentList();
		
		
		
		int nowPage = 0; // 현재 페이지 번호
		int totalCount = 0; // 총 게시물 수
		int pageSize = 10; // 한 페이지에서 출력할 게시물 수
		int totalPage = 0; // 총 페이지 수
		int begin = 0; // 페이징 시작 위치
		int end = 0; // 페이징 끝 위치
		int n = 0;
		int loop = 0;
		int blockSize = 10;

		if (page == null || page.equals("")) {
			nowPage = 1;
		} else {
			nowPage = Integer.parseInt(page);
		}
		HashMap<String, Integer> map = new HashMap<String, Integer>();

		begin = ((nowPage - 1) * pageSize) + 1;
		end = begin + pageSize - 1;

		map.put("begin", begin);
		map.put("end", end);

		
		
		List<AdviceDTO> list = adviceservice.getAdviceList(map);

		model.addAttribute("list", list);
	    
		for (AdviceDTO dto : list) {
			if (dto.getIscounselanswer().equals("y") || dto.getIscounselanswer().equals("Y")) {
				dto.setIscounselanswer("답변완료");
			} else {
				dto.setIscounselanswer("대기중");
			}
		}

		StringBuilder sb = new StringBuilder();

		totalCount = dao.getTotalCount();
		// System.out.println(totalCount);
		totalPage = (int) Math.ceil((double) totalCount / pageSize);
		// System.out.println(totalPage);
		loop = 1; // 루프 변수(10바퀴)
		n = ((nowPage - 1) / blockSize) * blockSize + 1;
		if (n == 1) {
			sb.append(String.format("<a href='#'!> 이전 | </a>"));
		} else {
			sb.append(String.format("<a href='/apa/advice/list.do?page=%d'> 이전 | </a>", n - 1));
		}

		while (!(loop > blockSize || n > totalPage)) {

			if (n == nowPage) {
				sb.append(String.format(" <a href='#!' style='color:tomato;'>%d</a> ", n));
			} else {
				sb.append(String.format(" <a href='/apa/advice/list.do?page=%d'>%d</a> ", n, n));
			}

			loop++;
			n++;

			if (n > totalPage) {
				break;
			}
		}

		// 다음 10페이지

		sb.append(String.format("<a href='/apa/advice/list.do?page=%d'> | 다음</a>", n));

		
		model.addAttribute("listDepartment", listDepartment);
		model.addAttribute("pagebar", sb);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("pageSize",pageSize);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("begin", begin);
		model.addAttribute("end", end);
		model.addAttribute("n", n);
		model.addAttribute("loop", loop);
		model.addAttribute("blockSize", blockSize);
		
		return "advice.list";

	}

	//진료과 목록 불러오기
	//추가하기 화면
	@GetMapping(value = "/advice/add.do")
	public String add(Model model) {
		List<AdviceDTO> add = adviceservice.getDepartmentList();

		model.addAttribute("add", add);
		
		return "advice.add";
	}
	
	// 추가하기
	@PostMapping(value = "/advice/add")
	@ResponseBody
	public int add(@RequestBody AdviceDTO dto) {
		
		
		return dao.add(dto);
	}
	
	

}
