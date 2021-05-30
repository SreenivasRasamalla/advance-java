package com.user.dao;

import com.user.bean.UserSigningBean;

public interface SigningInt {

				//pass the parameter according to the scenario
		
		public	boolean SignUpBy(String firstName, String lastName, String email, String password);
					
		public	boolean SignInBy(String email, String password);
		
		public boolean isExisted(String email);
		
		public UserSigningBean forgotPassword(String email);

}		