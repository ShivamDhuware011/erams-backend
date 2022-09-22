package com.example.Project.dto;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ForgotPasswordDto {
	
    @NotBlank(message = "email is required")
	private String useremail;
	public String password;
	

}
