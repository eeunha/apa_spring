package com.project.apa.community;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.apa.api.community.domain.CommunityCommentDTO;
import com.project.apa.api.community.domain.CommunityDTO;
import com.project.apa.api.community.service.CommunityService;

@Controller
public class CommunityController {

	@Autowired
	private CommunityService communityservice;
	
	@GetMapping(value = "/community/list.do")
	public String list(String page, Model model) {
		
		int nowPage = 0; // 현재 페이지 번호
		int totalCount = 0; // 총 게시물 수
		int pageSize = 30; // 한 페이지에서 출력할 게시물 수
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
		
		List<CommunityDTO> list = communityservice.getCommunityList(map);
		
		
		model.addAttribute("list", list);
		
		StringBuilder sb = new StringBuilder();

		totalCount = communityservice.getTotalCount();
		//System.out.println(totalCount);
		totalPage = (int) Math.ceil((double) totalCount / pageSize);
		 //System.out.println(totalPage);
		loop = 1; // 루프 변수(10바퀴)
		n = ((nowPage - 1) / blockSize) * blockSize + 1;
		if (n == 1) {
			sb.append(String.format("<a href='#'!> 이전 | </a>"));
		} else {
			sb.append(String.format("<a href='/apa/community/list.do?page=%d'> 이전 | </a>", n - 1));
		}

		while (!(loop > blockSize || n > totalPage)) {

			if (n == nowPage) {
				sb.append(String.format(" <a href='#!' style='color:tomato;'>%d</a> ", n));
			} else {
				sb.append(String.format(" <a href='/apa/community/list.do?page=%d'>%d</a> ", n, n));
			}

			loop++;
			n++;

			if (n > totalPage) {
				break;
			}
		}

		// 다음 10페이지
		System.out.println(pageSize);
		sb.append(String.format("<a href='/apa/community/list.do?page=%d'> | 다음</a>", n));

		
		model.addAttribute("pagebar", sb);
		model.addAttribute("userseq", '1');
	
		
		return "community.list";
	}
	
	//상세페이지
	//댓글불러오기
	@GetMapping(value = "/community/view.do")
	public String view(Model model, String seq) {
		
		CommunityDTO dto = communityservice.getCommunityInfo(seq);
		
		List<CommunityCommentDTO> listComment = communityservice.getCommentList(seq);
		
		//System.out.println(listComment.toString());
		model.addAttribute("listComment", listComment);
		model.addAttribute("dto", dto);
		model.addAttribute("userseq", '1');
		model.addAttribute("seq", listComment);
		model.addAttribute("communitycommentseq", listComment);
		return "community.view";
	}
	
	@GetMapping(value = "/community/getCommentList")
	@ResponseBody
	public List<CommunityCommentDTO> getCommentList(String seq) {
		
	    return communityservice.getCommentList(seq);
	}
	
	@PostMapping(value = "/community/commentadd")
	@ResponseBody
	public int commentadd(@RequestBody CommunityCommentDTO dto) {
		
		
		System.out.println(dto.toString());
		
		return communityservice.commentadd(dto);
	}
	
	@PostMapping(value="/community/commentdel")
	@ResponseBody
	public int commentdel(@RequestBody CommunityCommentDTO dto, String communitycommentseq) {
		
		
		System.out.println(dto.getCommunitycommentseq());
		
		return communityservice.commentdel(dto);
	}
	
	@GetMapping(value = "/community/add.do")
	public String add(Model model) {
		
		
		return "community.add";
	}
	
	@PostMapping(value = "/community/add")
	@ResponseBody
	public int add(@RequestBody CommunityDTO dto) {

		return communityservice.add(dto);
	}
	
	
	
	
	
}