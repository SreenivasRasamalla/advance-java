package com.user.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.log4j.Logger;

import com.user.bean.UserSigningBean;
import com.user.dao.SigningInt;
import com.user.dbutils.SigningDbUtil;

public class SigningImpl implements SigningInt {
	
	static final Logger LOGGER = Logger.getLogger(SigningImpl.class);
	
				////////SIGN UP IMPLEMENTAION  //////////////
	
	@Override
	public boolean SignUpBy(String firstName, String lastName, String email, String password) {
		// TODO Auto-generated method stub
		
				//SQL Query			//this is needed to connect with Schema in database?
				//Connection
				//Prepare Statement Object
				//ResultSet statement for data accessing from database ( use only when we need to make a query or check anything from the database )
				//execute Update or execute Query
		
		Connection con = null;
		UserSigningBean bean = new UserSigningBean();
		
		//String sql = "select * from sign ";
		String sql = "insert into sign (firstName, lastName, email, password) values (?,?,?,?)";
		boolean flag = false;
		
		
		try {
			SigningDbUtil object = new SigningDbUtil(); 
			con = object.getConnection();
			System.out.println("Connection Successfully Established"+ con);
		
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,firstName);
			ps.setString(2,lastName);
			ps.setString(3,email);
			ps.setString(4,password);
												
			int i = ps.executeUpdate();					// using .executeUpdate method to update the data or to make any changes in the database
			if (i==1) {
				flag = true;		//true; when data retrieves
				} else {
					flag = false;
					}
			
		} catch (Exception e) { 
			e.printStackTrace();
			// TODO: handle exception
		}	finally {
			if (con !=null) {
				try {
					con.close();
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		}
		return flag;
	}

	
	//////// SIGN IN IMPLEMENTAION  //////////////
	
	
	@Override
	public boolean SignInBy(String email, String password) {
		// TODO Auto-generated method stub
		LOGGER.info("Sign In method is called from Impl");
		
		Connection con = null;
		boolean flag = false;
		UserSigningBean bean = new UserSigningBean();
		String sql = "select * from sign where  email=? and password=? ";			//use only and here, commas are not working here
		
			
		try {
			SigningDbUtil object = new SigningDbUtil(); 
			con = object.getConnection();
			System.out.println("Connection Successfully Established"+ con);
		
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setString(1, email);
			stmt.setString(2, password);
														// here ResultSet statement is used with .executeQuery method
			ResultSet rs = stmt.executeQuery();			//data from the database will be available in ResultSet object 'rs'	& ( use ResultSet statement only when we need to make a query or check anything from the database )
														// .executeQuery method is used to make a query or check the data from the database
			if (rs.next()) {
				flag = true;
			
			} else {
				flag = false;
			}
			
			
			
		} catch (Exception e) { 
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			if (con !=null) {
				try {
					con.close();
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		}
		return flag;
	}
		
		////////  IMPLEMENTAION, IF DATA ALREADY EXISTS //////////////

	@Override
	public boolean isExisted(String email) {
		// TODO Auto-generated method stub
		LOGGER.info("is existed email called");
		Connection con = null;
		boolean flag = false;
		UserSigningBean bean = new UserSigningBean();
		String sql = "select * from sign where  email=? ";			//use only and here, commas are not working here
		
			
		try {
			SigningDbUtil object = new SigningDbUtil(); 
			con = object.getConnection();
			System.out.println("Connection Successfully Established"+ con);
		
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setString(1, email);
			
														// here ResultSet statement is used with .executeQuery method
			ResultSet rs = stmt.executeQuery();			//data from the database will be available in ResultSet object 'rs'	& ( use ResultSet statement only when we need to make a query or check anything from the database )
														// .executeQuery method is used to make a query or check the data from the database
			if (rs.next()) {
				flag = true;
			
			} else {
				flag = false;
			}
				
		} catch (Exception e) { 
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			if (con !=null) {
				try {
					con.close();
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		}
		return flag;
	}


	@Override
	public UserSigningBean forgotPassword(String email) {
		// TODO Auto-generated method stub
		
		UserSigningBean bean = new UserSigningBean();
		//SQL Query			//this is needed to connect with Schema in database?
		//Connection
		//Prepare Statement Object
		//ResultSet statement for data accessing from database			( use only when we need to make a query or check anything from the database )
		//execute Update or execute Query
		String sql = "select * from sign where email=? ";
		
		
		
		try {
			// logic here
			SigningDbUtil dbutl = new SigningDbUtil(); 
			Connection con = dbutl.getConnection();
			System.out.println("Connection Successfully Established    "+ con);
		
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();	//data from the database will be available in ResultSet object 'rs'  
												// .executeQuery method is used to make a query or check the data from the database
			if (rs.next()) {
				/*bean.setfirstName(rs.getString(1));			//.set() method is used to store values in database (from FrontEnd)
				bean.setEmpName(rs.getString(2));
				bean.setEmpSalary(rs.getString(3));
				bean.setEmpAddress(rs.getString(4));*/
				
				bean.setFirstName(rs.getString(1));
				bean.setLastName(rs.getString(2));
				bean.setEmail(rs.getString(3));
				bean.setPassword(rs.getString(4));
				
				
			}	
		
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		finally {
			
		}
		return bean;
	}

	}
