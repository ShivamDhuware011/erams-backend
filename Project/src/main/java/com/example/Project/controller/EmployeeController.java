package com.example.Project.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Project.entity.EmployeeEntity;
import com.example.Project.service.EmployeeServiceimpl;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class EmployeeController 
{

	@Autowired
    private EmployeeServiceimpl employeeService;
	
	 @PostMapping("/register")
	 public EmployeeEntity register (@RequestBody EmployeeEntity employeeentity)
	 {
		 System.out.println("employee registered successfully");
		return employeeService.register(employeeentity);	 
	 }
	
	  @GetMapping("/list") 
	  public List<EmployeeEntity> AllUser()
	  {
		  return employeeService.FetchAllUser();  
	  }
	 
	  @DeleteMapping("/list/{Emp_id}")
	  public String deleteEmp(@PathVariable("Emp_id") int Emp_id)
	  {
		  employeeService.deleteEmpById(Emp_id);
	    return "deleted succefully";
	  }
	 
	 @GetMapping("/list/{Emp_id}")
	 public EmployeeEntity getEmpById(@PathVariable("Emp_id")int Emp_id)
	 {
		 return employeeService.getEmpById(Emp_id);
		  
		
	 }
	 @PutMapping("/update/{Emp_id}")
	 public EmployeeEntity updateEmpDetails(@RequestBody EmployeeEntity employeeentity,@PathVariable ("Emp_id") int Emp_id)
{
		 EmployeeEntity employeeById = employeeService.getEmpById(Emp_id);
		 employeeentity.setFirst_name(employeeById.getFirst_name());
		 employeeentity.setLast_name(employeeById.getLast_name());
		 employeeentity.setAddress(employeeById.getAddress());
		 employeeentity.setContact_no(employeeById.getContact_no());
		 employeeentity.setE_mail(employeeById.getE_mail());
		 employeeentity.setDate_of_Birth(employeeById.getDate_of_Birth());
		 employeeentity.setDate_of_Joining(employeeById.getDate_of_Joining());
		 employeeentity.setEmp_code(employeeById.getEmp_code());
		 employeeentity.setPassword(employeeById.getPassword());
		 System.out.println("in update employee dtls" + employeeentity);
		 return employeeService.updateEmp(employeeentity);
      /*employeeService.updateEmpById(employeeentity,Emp_id);
      return employeeentity;*/
}
	 
	  
}
	
	
