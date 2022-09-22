package com.example.Project.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true,exclude = {"password","employeeentity"})

@Entity
@Table(name = "User")
public class UserEntity {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
 private long user_id;

@Column(nullable = false,unique = true)
 private String username;

@Column(nullable = false,unique = true)
 private String password;

@Column(nullable = false,unique = true)
 private String useremail;

//@OneToOne(fetch = FetchType.EAGER)
//@JoinColumn(name = "Emp_id")
//@JsonIgnore
@OneToOne(mappedBy = "userentity",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
private EmployeeEntity employeeentity;

@OneToMany(mappedBy = "userentity",cascade = CascadeType.ALL)
public List<ClubEntity> clubentity;
 
}
