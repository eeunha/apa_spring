package com.project.apa.api.hospital.medi.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.apa.api.hospital.medi.domain.AppointmentDetailDTO;
import com.project.apa.api.hospital.medi.domain.AppointmentListDTO;
import com.project.apa.api.hospital.medi.domain.TreatmentListDTO;
import com.project.apa.api.hospital.medi.persistence.AppointmentDetailDAO;
import com.project.apa.api.hospital.medi.persistence.AppointmentListDAO;
import com.project.apa.api.hospital.medi.persistence.TreatmentDetailDAO;
import com.project.apa.api.hospital.medi.persistence.TreatmentListDAO;

@Service
public class PracticeServiceImpl implements PracticeService {

	@Autowired
	private AppointmentListDAO appointmentListDAO;

	@Autowired
	private AppointmentDetailDAO appointmentDetailDAO;

	@Autowired
	private TreatmentListDAO treatmentListDAO;

	@Autowired
	private TreatmentDetailDAO treatmentDetailDAO;

	// 오늘의 진료 - 예약 - 목록
	@Override
	public List<AppointmentListDTO> getTodayAppointmentList(HashMap<String, Object> map) {

		return appointmentListDAO.getTodayAppointmentList(map);
	}

	// 모든 진료 - 예약 - 목록
	@Override
	public List<AppointmentListDTO> getAllAppointmentList(HashMap<String, Object> map) {

		int page = (int) map.get("page");

		int end = page * 10;
		int begin = end - 9;

		map.put("begin", begin);
		map.put("end", end);

		return appointmentListDAO.getAllAppointmentList(map);
	}

	// 모든 진료 - 예약 - 목록 - 페이지바
	@Override
	public String getAllAppointmentListPageBar(HashMap<String, Object> map) {

		int nowPage = 0;
		// 해당 병원의 총 예약 수
		int totalCount = 0;
		int pageSize = 10; // 한 페이지에서 출력할 게시물 수
		int totalPage = 0; // 총 페이지 수
		int begin = 0; // 페이징 시작 위치
		int end = 0; // 페이징 끝 위치
		int n = 0; // 현재 페이지
		int loop = 0;
		int blockSize = 10; // 한번에 보여줄 페이지 개수

		nowPage = (int) map.get("page");

		begin = ((nowPage - 1) * pageSize) + 1;
		end = begin + pageSize - 1;

		totalCount = appointmentListDAO.getAllAppointmentCount((String) map.get("id"));

		totalPage = (int) Math.ceil((double) totalCount / pageSize);

		StringBuilder sb = new StringBuilder();

		loop = 1; // 루프 변수(10바퀴)

		n = ((nowPage - 1) / blockSize) * blockSize + 1; // 출력 페이지 번호

		// 이전 10페이지
		if (n == 1) {
			sb.append(" <a href='#!';>[이전 페이지]</a>&nbsp;&nbsp;");
		} else {
			sb.append(
					String.format(" <a href='/apa/hospital/%s/medi/all/appointment?page=%d';>[이전 페이지]</a>&nbsp;&nbsp;",
							(String) map.get("id"), n - 1));
		}

		while (!(loop > blockSize || n > totalPage)) {

			if (n == nowPage) {
				sb.append(String.format(" <a href='#!' style='color:tomato;'>%d</a>&nbsp;&nbsp;", n));
			} else {
				sb.append(String.format(" <a href='/apa/hospital/%s/medi/all/appointment?page=%d'>%d</a>&nbsp;&nbsp;",
						(String) map.get("id"), n, n));
			}

			loop++;
			n++;
		}

		// 다음 10페이지
		if (n > totalPage) {
			sb.append(" <a href='#!';>[다음 페이지]</a> ");
		} else {
			sb.append(String.format(" <a href='/apa/hospital/%s/medi/all/appointment?page=%d';>[다음 페이지]</a> ",
					(String) map.get("id"), n));
		}

		return sb.toString();
	}

	// 모든 진료 - 예약 - 상세보기
	@Override
	public AppointmentDetailDTO getAllAppointmentDetail(int appointmentSeq) {

		return appointmentDetailDAO.getAllAppointmentDetail(appointmentSeq);
	}

	// 모든 진료 - 진료 - 목록
	@Override
	public List<TreatmentListDTO> getAllTreatmentList(HashMap<String, Object> map) {

		int page = (int) map.get("page");

		int end = page * 10;
		int begin = end - 9;

		map.put("begin", begin);
		map.put("end", end);

		return treatmentListDAO.getTreatmentList(map);
	}

	// 모든 진료 - 진료 - 목록 - 페이지바
	@Override
	public String getAllTreatmentListPageBar(HashMap<String, Object> map) {

		int nowPage = 0;
		int totalCount = 0; // 해당 병원의 총 진료 수
		int pageSize = 10; // 한 페이지에서 출력할 게시물 수
		int totalPage = 0; // 총 페이지 수
		int begin = 0; // 페이징 시작 위치
		int end = 0; // 페이징 끝 위치
		int n = 0; // 현재 페이지
		int loop = 0;
		int blockSize = 10; // 한번에 보여줄 페이지 개수

		nowPage = (int) map.get("page");

		begin = ((nowPage - 1) * pageSize) + 1;
		end = begin + pageSize - 1;

		totalCount = treatmentListDAO.getAllTreatmentCount((String) map.get("id"));
		
		totalPage = (int) Math.ceil((double) totalCount / pageSize);

		StringBuilder sb = new StringBuilder();

		loop = 1; // 루프 변수(10바퀴)

		n = ((nowPage - 1) / blockSize) * blockSize + 1; // 출력 페이지 번호

		// 이전 10페이지
		if (n == 1) {
			sb.append(" <a href='#!';>[이전 페이지]</a>&nbsp;&nbsp;");
		} else {
			sb.append(
					String.format(" <a href='/apa/hospital/%s/medi/all/treatment?page=%d';>[이전 페이지]</a>&nbsp;&nbsp;",
							(String) map.get("id"), n - 1));
		}

		while (!(loop > blockSize || n > totalPage)) {

			if (n == nowPage) {
				sb.append(String.format(" <a href='#!' style='color:tomato;'>%d</a>&nbsp;&nbsp;", n));
			} else {
				sb.append(String.format(" <a href='/apa/hospital/%s/medi/all/treatment?page=%d'>%d</a>&nbsp;&nbsp;",
						(String) map.get("id"), n, n));
			}

			loop++;
			n++;
		}

		// 다음 10페이지
		if (n > totalPage) {
			sb.append(" <a href='#!';>[다음 페이지]</a> ");
		} else {
			sb.append(String.format(" <a href='/apa/hospital/%s/medi/all/treatment?page=%d';>[다음 페이지]</a> ",
					(String) map.get("id"), n));
		}

		return sb.toString();
	}
}
