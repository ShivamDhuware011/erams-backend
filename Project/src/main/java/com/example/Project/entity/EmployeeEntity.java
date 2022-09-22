package com.example.Project.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true,exclude = "Password")
@Getter
@Setter

@Entity
@Table(name = "Employee")
public class EmployeeEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Emp_id;
	
	@Column(nullable = false,length = 100)
	private String First_name;
	
	@Column(nullable = false,length = 100)
	private String Last_name;
	
	@Column(nullable = false)
	private LocalDate Date_of_Birth;
	
	@Column(nullable = false,unique = true)
	private int Contact_no;
	
	@Column(nullable = false,length = 100,unique = true)
	private String E_mail;
	
	@Column(nullable = false,length = 255)
	private String Address;
	
	@Column(nullable = false,length = 100,unique = true)
	private String Password;
	
	@Column(nullable = false)
	private LocalDate Date_of_Joining;
	
	@Column(nullable = false,unique = true)
	private String Emp_code;
	
	@Column
	private boolean status;
	
	//@OneToOne(mappedBy = "employeeentity",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
    @JsonIgnore
	private UserEntity userentity;

}
