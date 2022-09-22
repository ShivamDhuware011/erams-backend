package com.example.Project.service;

import java.net.PasswordAuthentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.Project.custom_exception.ResourceNotFoundException;
import com.example.Project.dao.UserDao;
import com.example.Project.entity.UserEntity;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserDao userdao;
	
	/*@Autowired
	private encoder;*/
	

	@Override
	public UserEntity Login(String username, String password) {
		UserEntity user = userdao.findByUsernameAndPassword(username, password)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Credentials !!!"));
		return user;
	}

	@Override
	public UserEntity ForgotPassword(String useremail) {
		UserEntity user = userdao.findByUseremail(useremail)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Email !!"));
		return user;
	}
	
	public String ChangePassword(String newpassword,long user_id) {
	  UserEntity user = userdao.findById(user_id)
			  .orElseThrow(() -> new ResourceNotFoundException("Invalid User_id !!!"));
	//  user.setPassword(encoder.encode(newpassword));
	  user.setPassword(newpassword);
	  userdao.save(user);
	  return "Password changed Successfully";
	}

}
