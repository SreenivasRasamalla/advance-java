package com.employ.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.employ.bean.EmployBean;
import com.employ.dao.EmployInterface;
import com.employ.dbutils.Dbutil;




public class EmployImpl implements EmployInterface {
	
	Connection con = null;

	@Override
	public EmployBean getEmployRecordById(String empId) {
		// TODO Auto-generated method stub
		EmployBean bean = new EmployBean();
		//SQL Query			//this is needed to connect with Schema in database?
		//Connection
		//Prepare Statement Object
		//ResultSet statement for data accessing from database			( use only when we need to make a query or check anything from the database )
		//execute Update or execute Query
		String sql = "select * from emp where empId=? ";
		
		
		
		try {
			// logic here
			Dbutil dbutl = new Dbutil(); 
			Connection con = dbutl.getConnection();
			System.out.println("Connection Successfully Established    "+ con);
		
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, empId);
			ResultSet rs = ps.executeQuery();	//data from the database will be available in ResultSet object 'rs'  
												// .executeQuery method is used to make a query or check the data from the database
			if (rs.next()) {
				bean.setEmpId(rs.getString(1));			//.set() method is used to store values in database (from FrontEnd)
				bean.setEmpName(rs.getString(2));
				bean.setEmpSalary(rs.getString(3));
				bean.setEmpAddress(rs.getString(4));
			}
		
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		finally {
			
		}
		return bean;
	}

	
	@Override
	public boolean addEmploy(String empId, String empName, String empSalary, String empAddress) {
		// TODO Auto-generated method stub
	
		
		String sql = "insert into emp (empId, empName, empSalary, empAddress) values (?,?,?,?)";
		boolean flag = false;
		
		
		try {
			Dbutil obj = new Dbutil(); 
			Connection con = obj.getConnection();
			System.out.println("Connection Successfully Established"+ con);
		
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1,empId);
			ps.setString(2,empName);
			ps.setString(3,empSalary);
			ps.setString(4,empAddress);
			
			int i = ps.executeUpdate();						// using .executeUpdate method to update the data or to make any changes in the database
			if (i==1) {
				flag = true;		//true; when data retrieves
				} else {
					flag = false;
					}
			
		} catch (Exception e) { 
			e.printStackTrace();
			// TODO: handle exception
		}
		return flag;
	}


	@Override
	public boolean updateEmp(String empId, String empName, String empSalary, String empAddress) {
		// TODO Auto-generated method stub
		String sql = ("update emp set empName=?, empSalary=?, empAddress=? where empId=?");
		boolean flag = false;
		
		try {
			Dbutil obj = new Dbutil(); 
			Connection con = obj.getConnection();
			System.out.println("Connection Successfully Established"+ con);
		
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,empName);
			ps.setString(2,empSalary);
			ps.setString(3,empAddress);
			ps.setString(4,empId);
			
			int i = ps.executeUpdate();					// using .executeUpdate method to update the data or to make any changes in the database
			if (i==1) {
				flag = true;		//true; when data retrieves
				} else {
					flag = false;
					}
			
		} catch (Exception e) { 
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			
			if (con!=null);
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("your connection is closed");
				e.printStackTrace();
			}
		}
		return flag;
		
	}


	@SuppressWarnings("finally")
	@Override
	public boolean deleteEmp(String empId, String empName, String empSalary, String empAddress) {
		// TODO Auto-generated method stub
		
		String sql = ("delete from emp where empId=?");
		boolean flag = false;
		
		try {
			
				Dbutil DbUtil = new Dbutil();
				con = DbUtil.getConnection();
				System.out.println("connection success"+ con);
				
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setString(1,empId);
					            
				int i =ps.executeUpdate();  				// using .executeUpdate method to update the data or to make any changes in the database
				if (i==1) {
					flag = true;
				}else {
					
					flag = false;
				}
				
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			
			if (con!=null);
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("your connection is closed");
				e.printStackTrace();
			
		}
		
		}
		return flag;
	}
}

	


 