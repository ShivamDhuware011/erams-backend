package com.example.Project.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LoginDto {
	
	@NotBlank(message = "Username is required")
	private String username;
	
	@NotBlank
	//@Pattern(regexp = "[0-9][a-z][A-Z]{5,8}", message = "Blank or Invalid Password")
	private String password;

}
