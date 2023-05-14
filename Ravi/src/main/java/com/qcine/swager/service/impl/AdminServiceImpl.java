package com.qcine.swager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.qcine.swager.entity.Admin;
import com.qcine.swager.exception.Admin_Not_found_Exception;
import com.qcine.swager.exception.Adminemail_Or_adminname_and_pwd_exception;
import com.qcine.swager.exception.ConfirmFassword_Not_Matched;
import com.qcine.swager.repository.AdminRepo;
import com.qcine.swager.service.inter.AdminServiceinter;

@Service
public class AdminServiceImpl  implements AdminServiceinter
{
	@Autowired
	private AdminRepo adminrepo;
	
	@Autowired
	private JavaMailSender mailsender;

	@Override
	public Object adminsignup(Admin admin)
	{
		Admin email = adminrepo.findByEmain(admin.getAdmin_Email());
		
		if(email==null)
		{
			  adminrepo.save(admin);
			   SimpleMailMessage mess = new SimpleMailMessage();
			   mess.setFrom("siddalinganaikcs@gmail.com");
			   mess.setTo(admin.getAdmin_Email());
			   mess.setSubject("you are login successfully");
			   mess.setText("you are login successfully");
			   
			   mailsender.send(mess);
			return adminrepo.save(admin);
		}
		else
		{
			try
			{
				throw new Admin_Not_found_Exception(admin);
			}
			catch(Admin_Not_found_Exception a)
			{
				return a.getMessage();
			}
		}
	}

	@Override
	public Object adminlogin(String email, String pwd) 
	{
	
		
		Admin ttt = adminrepo.findByEmailandPassword(email, pwd);
		if(ttt!=null)
		{
			return ttt;
		}
		else
		{
			try
			{
				throw new Adminemail_Or_adminname_and_pwd_exception(email);
			}
			catch(Adminemail_Or_adminname_and_pwd_exception e)
			{
				return e.getMessage();
			}
		}
	}

	@Override
	public Object adminforgetpass(String emil, String password, String conformpassword) {
	
		Admin bbb = adminrepo.findByEmain(emil);
		
		if(bbb!=null  && password.equals(conformpassword))
		{ 

				bbb.setAdmin_Password(password);
				bbb.setAdmin_Email(emil);
				
				 
				   SimpleMailMessage mess = new SimpleMailMessage();
				   mess.setFrom("siddalinganaikcs@gmail.com");
				   mess.setTo(emil);
				   mess.setSubject("password successfully update");
				   mess.setText("password successfully update");
				   
				   mailsender.send(mess);
				 adminrepo.save(bbb);
				 return bbb;}
		else
		{
			try
			{
				throw new ConfirmFassword_Not_Matched(conformpassword);
			}
			catch(ConfirmFassword_Not_Matched e)
			{
				return e.getMessage();
			}
			
		}
	}

}
