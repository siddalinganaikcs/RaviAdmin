package com.qcine.swager.exception;

import com.qcine.swager.entity.Admin;

public class Admin_Not_found_Exception  extends RuntimeException
{

	public Admin_Not_found_Exception(Admin message) {
		super("Admin not found exception");
		
	}

	
}
