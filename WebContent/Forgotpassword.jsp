<%@page import="java.io.PrintWriter"%>
<%@page import="com.user.bean.UserSigningBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Forgot password</title>
</head>
<body>
		 
 	<% 	UserSigningBean bean = (UserSigningBean)request.getAttribute("b");
String pwd = bean.getPassword();

out.println("Your Password is.........."+" "+ pwd); %>


</body>
</html>