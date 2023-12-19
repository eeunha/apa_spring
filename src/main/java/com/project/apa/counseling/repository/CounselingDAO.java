package com.project.apa.counseling.repository;

import java.util.List;

import com.project.apa.counseling.model.CounselingDTO;
import com.project.apa.counseling.model.CounselingPageDTO;

public interface CounselingDAO {
    List<CounselingDTO> list(CounselingPageDTO pdto);

    int getTotalCount(CounselingPageDTO pdto);

	CounselingDTO get(int mediCounselQuestionSeq);

	void answeradd(CounselingDTO counselingdto);

	void answerupdate(CounselingDTO counselingdto);

	CounselingDTO getcomplete(int mediCounselQuestionSeq);
}
