package org.mks.two.dao;

import org.mks.two.entities.SubjectEntity;
import org.mks.two.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectDAO {
	
	@Autowired
	private SubjectRepository subjectRepository;
	
	public String saveSubjectEntity(SubjectEntity subjectEntity){
		try{
			subjectRepository.save(subjectEntity);
		}catch(Exception e){
			e.printStackTrace();
		}
		return "Success";
	}
	
	public SubjectEntity fetchSubjectEntity(Long id){
		return subjectRepository.findOne(id);
	}
}
