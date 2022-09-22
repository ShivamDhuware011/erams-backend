package com.example.Project.service;
import java.util.List;

import com.example.Project.entity.EmployeeEntity;


public interface IEmployeeService {

	public EmployeeEntity register(EmployeeEntity employee);
	public List<EmployeeEntity> FetchAllUser(); 
	public void deleteEmpById(int Emp_id);
	public EmployeeEntity getEmpById(int Emp_id);
	public EmployeeEntity updateEmp(EmployeeEntity employeeentity);
}
