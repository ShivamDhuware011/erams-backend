package com.example.Project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Project.custom_exception.ResourceNotFoundException;
import com.example.Project.dto.ApiResponse;
import com.example.Project.dto.ForgotPasswordDto;
import com.example.Project.dto.LoginDto;
import com.example.Project.entity.UserEntity;
import com.example.Project.service.IUserService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private IUserService userservice;
	
	@PostMapping("/login")
		public ResponseEntity<?> login(@RequestBody LoginDto logindto) {
	   try {
		   return ResponseEntity.status(HttpStatus.CREATED).body(userservice.Login(logindto.getUsername(),logindto.getPassword()));
	   }catch(RuntimeException e) {
		   return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(e.getMessage()));
	   }
	}
	
	@PutMapping("/forgotpassword")
	public ResponseEntity<?> ForgotPassword(@RequestBody ForgotPasswordDto forgotpassworddto){
		try {
			System.out.println("in forgot password of " +getClass());
			UserEntity userentity = userservice.ForgotPassword(forgotpassworddto.getUseremail());
			String changepassword = userservice.ChangePassword(forgotpassworddto.getPassword(),userentity.getUser_id());
			return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse(changepassword));
		}
		catch (ResourceNotFoundException e) {
			System.out.println("in forgot password err " + e);
			return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body(new ApiResponse(e.getMessage()));
		}
	}
	}
