<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.sql.*"%>
<% Class.forName("com.mysql.jdbc.Driver"); %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>The View Of Database Table</title>
</head>
<body BGCOLOR="white">
	<H1>The View Of Database Table</H1>
	<%
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root", "060795");    
       Statement statement = con.createStatement() ;
       ResultSet resultset = statement.executeQuery("select * from emp") ; 
        %>
	<TABLE BORDER="1">
		<TR>
			<TH>Employ ID</TH>
			<TH>Employ Name</TH>
			<TH>Employ Salary</TH>
			<TH>Employ Address</TH>
		</TR>
		<% while(resultset.next()){ %>
		<TR>
			<TD><%= resultset.getString(1) %></td>
			<TD><%= resultset.getString(2) %></TD>
			<TD><%= resultset.getString(3) %></TD>
			<TD><%= resultset.getString(4) %></TD>
		</TR>
		<% } %>
	</TABLE>
</body>
</html>
