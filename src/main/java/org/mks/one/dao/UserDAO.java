package org.mks.one.dao;

import org.mks.one.entities.UserEntity;
import org.mks.one.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDAO {
	
	@Autowired
	private UserRepository userRepository;
	
	public String saveUserEntity(UserEntity userEntity){
		try{
			userRepository.save(userEntity);
		}catch(Exception e){
			e.printStackTrace();
		}
		return "Success";
	}
	
	public UserEntity fetchUserEntity(Long id){
		return userRepository.findOne(id);
	}
}
