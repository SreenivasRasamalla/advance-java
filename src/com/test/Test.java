package com.test;

import com.google.gson.Gson;


public class Test {
	
	private String empName;
	private String empId;
	private String empSalary;
	private String empAddress;
	


@Override
public String toString() {
	return "Test [empName=" + empName + ", empId=" + empId + ", empSalary=" + empSalary + ", empAddress=" + empAddress
			+ "]";
}



public String getEmpName() {
	return empName;
}



public void setEmpName(String empName) {
	this.empName = empName;
}



public String getEmpId() {
	return empId;
}



public void setEmpId(String empId) {
	this.empId = empId;
}



public String getEmpSalary() {
	return empSalary;
}



public void setEmpSalary(String empSalary) {
	this.empSalary = empSalary;
}



public String getEmpAddress() {
	return empAddress;
}

public void setEmpAddress(String empAddress) {
	this.empAddress = empAddress;
}
	
		public static void main(String[] args) {/*
			
			
			Test obj = new Test();
			obj.setEmpName("Alexa");
			obj.setEmpId("22912");
			obj.setEmpSalary("99999");
			obj.setEmpAddress("@Corona World");
						
			System.out.println("Java Object"+obj);
			
			System.out.println("Json Object"+new Gson().toJson(obj));
			 
		*/}
		


}
