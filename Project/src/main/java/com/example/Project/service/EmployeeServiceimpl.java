package com.example.Project.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.Project.custom_exception.ResourceNotFoundException;
import com.example.Project.dao.EmployeeDao;
import com.example.Project.entity.EmployeeEntity;

import java.util.List;

@Service
@Transactional
public class EmployeeServiceimpl implements IEmployeeService {

	@Autowired
	private EmployeeDao employeeDao;
     
	
	
	/* @Autowired 
	 private PasswordEncoder passwordencoder;*/
	 
	 
	
	
	/* Employee Registration */
	@Override
	public EmployeeEntity register(EmployeeEntity employeeentity)
	{
		
		/* String encodedpassword= passwordencoder.encode(employeeentity.getPassword());
		 employeeentity.setPassword(encodedpassword);*/
		 
		  return employeeDao.save(employeeentity);
	}
    
	/* List of Employee */
	@Override
	public List<EmployeeEntity> FetchAllUser()
	{ 
		  List<EmployeeEntity> employeeentity = (List<EmployeeEntity>) employeeDao.findAll(); 
		  return employeeentity;
	}

	/* Delete Employee By Id */
	@Override
	public void deleteEmpById(int Emp_id) 
	{
		 employeeDao.deleteById(Emp_id);	
	}
	
	/* Get Particular Employee Information By Id */
	@Override
	public EmployeeEntity getEmpById(int Emp_id)
	{
		return employeeDao.findById(Emp_id).get();		
	}
	 
	 @Override
		public EmployeeEntity updateEmp(EmployeeEntity employeeentity)
		{
			employeeDao.findById(employeeentity.getEmp_id()).orElseThrow(() -> new ResourceNotFoundException("Invalid Emp ID!!!!!! : Can't Update details"));
		System.out.println("update successfull");
			return employeeDao.save(employeeentity);
		}
	


	}
