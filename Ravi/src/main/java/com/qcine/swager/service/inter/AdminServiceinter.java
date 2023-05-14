package com.qcine.swager.service.inter;

import com.qcine.swager.entity.Admin;

public interface AdminServiceinter 
{
	public Object adminsignup( Admin admin);
	
	public Object adminlogin(String email,String password);
	
	public Object adminforgetpass(String emil,String password,String conformpassword);

}
