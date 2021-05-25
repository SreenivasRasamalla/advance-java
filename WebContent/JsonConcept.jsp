<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JSon</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<title>JSON</title>

<script type="text/javascript">
 alert('hello');
$(document).ready(function(){
	alert('Json Jquery is called');
		
	$("#submit").click(function(){
		
		alert('onClick called');
		
		//taking the inputs here
		/*  var empName = $('empName').val();
		var empId = $('empId').val();
		var empSalary = $('empSalary').val();
		var empAddress = $('empAddress').val();
		
		 
		if (empName == "" || empId == "" || empSalary == "" || empAddress == "" ) {
		alert('Please fill out all the required fields');
			
		}else {
		
			var myVar = JSON.stringify({empName : empName , empId : empId , empSalary : empSalary , empAddress : empAddress});
			//var myVar = JSON.stringfy(jsondata);
			
		alert(myVar);
		} */
		 
		alert('Json Ajax is called');
		$.ajax({
			url:'./Jsonservlet1',
			type: 'GET',
			//data: {empName:empName , empId:empId , empSalary:empSalary , empAddress: empAddress},
							
		 	//data: "para="+ myVar,  //sending json data
			//dataType : "json",
			
			success: function(result){
				alert(result);	
				},
			error: function(err){
				alert("Unable to retrieve data"+err);
			}
		}); 
	});
});
</script>
	
</head>
<body>
<form action="" id = "submit">
<!-- Employee Name <input type="text" name = "empName" id = "empName">
Employee Id <input type="text" name = "empId" id = "empId">
Employee Salary <input type="text" name = "empSalary" id = "empSalary">
Employee Address <input type="text" name = "empAddress" id = "empAddress"> 
 -->		<input type = "button" value = "submit" id = "submit">
</form>
<div id = "result"></div>
</body>
</html>