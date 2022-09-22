package com.example.Project.service;

import com.example.Project.entity.UserEntity;

public interface IUserService {

	public UserEntity Login(String username,String password);
	public UserEntity ForgotPassword(String useremail);
	public String ChangePassword(String newpassword,long user_id);
}
