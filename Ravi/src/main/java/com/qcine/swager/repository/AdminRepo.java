package com.qcine.swager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qcine.swager.entity.Admin;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Integer>
{
     @Query(value = "select * from admin where admin_email=?1" , nativeQuery = true)
     public Admin findByEmain(String email);
     
   @Query(value = "select * from admin where admin_email=?1 and admin_password=?2",nativeQuery = true)
   public Admin findByEmailandPassword(String email,String password);
     
     
     
}
