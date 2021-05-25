package com.filter;

import java.util.HashMap;
import java.util.Map;


public class AuthImpl implements AuthInterface {

	public AuthImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean validLogin(String user, String pass) {
		// TODO Auto-generated method stub
		boolean flag = false;
		
		Map<String, String> map = new HashMap<String, String>();
		
		try {
			map.put("userName", "Sree");
			map.put("pwd", "1234");
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		if (map.containsValue(user) && map.containsValue(pass)){
			flag = true;
		} else {
			flag = false;
		}
		return flag;
	}

}
