package com.qcine.swager.exception;

import com.qcine.swager.entity.Admin;

public class Adminemail_Or_adminname_and_pwd_exception extends RuntimeException
{

	public Adminemail_Or_adminname_and_pwd_exception(String message) {
		super("Email and password Are Not Invaled pls Check Again");
		
	}
   
}
