package com.project.apa.counseling.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.apa.counseling.model.CounselingDTO;
import com.project.apa.counseling.model.CounselingPageDTO;
import com.project.apa.mapper.CounselingMapper;

@Repository
public class CounselingDAOImpl implements CounselingDAO{
	
	@Autowired
	private CounselingMapper cmapper;



	@Override
	public List<CounselingDTO> list(CounselingPageDTO pdto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTotalCount(CounselingPageDTO pdto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public CounselingDTO get(int mediCounselQuestionSeq) {
		
		return cmapper.get(mediCounselQuestionSeq);
	}

	@Override
	public void answeradd(CounselingDTO counselingdto) {
		// TODO Auto-generated method stub
		System.out.println( counselingdto.getCounselAnswerContent());
		System.out.println( counselingdto.getMediCounselQuestionSeq());
		System.out.println( counselingdto.getDoctorSeq());
		
		cmapper.answeradd(counselingdto);
		
	}

	@Override
	public void answerupdate(CounselingDTO counselingdto) {
		cmapper.answerupdate(counselingdto);
	}

	@Override
	public CounselingDTO getcomplete(int mediCounselQuestionSeq) {
		// TODO Auto-generated method stub
		return cmapper.getcomplete(mediCounselQuestionSeq);
	}

}
