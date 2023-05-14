package com.qcine.swager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.qcine.swager.entity.Admin;
import com.qcine.swager.service.inter.AdminServiceinter;

@RestController
public class AdminController 
{
	@Autowired
	private AdminServiceinter adminserviceinter;
	
	@PostMapping("/adminsignup")
	ResponseEntity<?> adminsignup( @RequestBody Admin admin)
	{
		
		 Object signup = adminserviceinter.adminsignup(admin);
		 
		 if(signup.equals(admin))
		 {
			 return ResponseEntity.status(200).body("Admin successfully signup");
		 }
		 else
		 {
			 return ResponseEntity.status(400).body(adminserviceinter.adminsignup(admin));
		 }
	}

	
	
	@GetMapping("adminlogin")
	ResponseEntity<?> adminlogin(@RequestHeader String email , @RequestHeader String pwd)
	{
		
		 Object login = adminserviceinter.adminlogin(email, pwd);
		 
		
		 
		 if(login !="Email and password Are Not Invaled pls Check Again")
		 {
			 return ResponseEntity.status(200).body("Admin successfully login");
		 }
		 else
		 {
			 return ResponseEntity.status(400).body(adminserviceinter.adminlogin(email, pwd));
		 }
	}
	
	
	
	@GetMapping("adminforgetpassword")
	ResponseEntity<?> adminforgrtpass(@RequestHeader String email , @RequestHeader String password,@RequestHeader String conformpassword)
	{
		
		 Object login = adminserviceinter.adminforgetpass(email, password, conformpassword);
		 
		
		 
		 if(login !=null)
		 {
			 return ResponseEntity.status(200).body("password successfully update");
		 }
		 else
		 {
			 return ResponseEntity.status(400).body(adminserviceinter.adminforgetpass(email, password, conformpassword));
		 }
	}
	
	
}
