package com.employ.dbutils;

import java.sql.Connection;
import java.sql.*;

public class Dbutil {
	
	String url="jdbc:mysql://localhost:3306/mydb";  //sonoo means Schema
	String driverClass="com.mysql.jdbc.Driver";
	String user="root";
	String pass="060795";
	
	Connection con = null;
		
	public Connection getConnection(){
		
		
		try {
			// database logic here
			// 4 properties are required to connect with any database, 1)username, 2) password, 3) url, 4) driver Class
			System.out.println("dbutil class");
			Class.forName(driverClass);
			 con =  DriverManager.getConnection(url,user,pass);
			System.out.println("From Dbutil");
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		return con;
		
	}
	
	public static void main(String[] args) {		//main method is temporarily used here to check whether the connection is successfull or not
		Dbutil obj = new Dbutil();
		Connection con = obj.getConnection();
		System.out.println("Connection done Successfully.."+con);
	}

}

