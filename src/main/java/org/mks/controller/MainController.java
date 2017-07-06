package org.mks.controller;

import org.mks.one.dao.UserDAO;
import org.mks.one.entities.UserEntity;
import org.mks.two.dao.SubjectDAO;
import org.mks.two.entities.SubjectEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/main")
public class MainController {
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private SubjectDAO subjectDAO;
	
	@RequestMapping(method=RequestMethod.POST, value="/user")
	public String user(@RequestBody UserEntity userEntity){
		return userDAO.saveUserEntity(userEntity);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/subject")
	public String subject(@RequestBody SubjectEntity subjectEntity){
		return subjectDAO.saveSubjectEntity(subjectEntity);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/user/{id}")
	public UserEntity getUser(@PathVariable("id") Long id){
		return userDAO.fetchUserEntity(id);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/subject/{id}")
	public SubjectEntity getSubject(@PathVariable("id") Long id){
		return subjectDAO.fetchSubjectEntity(id);
	}
	
}
