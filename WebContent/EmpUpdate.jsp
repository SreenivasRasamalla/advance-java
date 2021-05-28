<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action = "./EmpUpdateServlet">
            <label>Employee Id : </label>   
            <input type="text" placeholder="Enter EmployeeID" name="empId" required>  
            <label>EmployeeName : </label>   
            <input type="text" placeholder="Enter employeeName" name="empName" required>  
             <label>EmployeeSalary : </label>   
            <input type="text" placeholder="Enter employeeSalary" name="empSalary" required>  
             <label>EmployeeAddress : </label>   
            <input type="text" placeholder="Enter employeeAddress" name="empAddress" required> 
        

<input type = "submit" value = "updateEmployeeRecords"> 

</form>
</body>
</html>