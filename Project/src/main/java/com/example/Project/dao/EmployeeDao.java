package com.example.Project.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Project.entity.EmployeeEntity;

public interface EmployeeDao extends JpaRepository<EmployeeEntity, Integer>{

}
