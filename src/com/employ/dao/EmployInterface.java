package com.employ.dao;

import com.employ.bean.EmployBean;

public interface EmployInterface {
	
	public EmployBean getEmployRecordById(String empId);  //pass the parameter according to the scenario, here we are trying get the employe details by emp ID number
	
	public boolean addEmploy(String empId, String empName, String empSalary, String empAddress);

	public boolean updateEmp(String empId, String empName, String empSalary, String empAddress);

	public boolean deleteEmp(String empId, String empName, String empSalary, String empAddress);
	

}
