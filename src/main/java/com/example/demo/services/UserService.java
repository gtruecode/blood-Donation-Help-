package com.example.demo.services;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.models.Admin;
import com.example.demo.models.User;
import com.example.demo.repository.UserRepo;

@Service
@Transactional
public class UserService 
{

	@Autowired
	UserRepo userrepo;
	
//--------------------------------------------------------------------------------------------//	
	public String saveUser(User u) 
	{ 
		String pageName;
		if(userrepo.existsById(u.getEmail()))
			{
		        pageName="userexists.html";
			}
		else {
			userrepo.save(u);
			pageName="successregistration.html";
		     }
		return pageName;
		
//		 userrepo.save(u);
//		 return "successregistration.html";
	}

//-------------------------------------------------------------------------------------------------

	public String checklogin(User m)
	{
		String pageName=null;
		
		
		if(userrepo.existsById(m.getUsername()))
		{
			
			User user=userrepo.getById(m.getUsername());
			if(m.getPassword().equals(user.getPassword()))
			{
				System.out.println("loggedin");
				 pageName="userafterlogin.html";
				
			}
			else
			{
				System.out.println("Failure");
				 pageName="userloginfailedforpassword.html";
			}
		}
		else
		{
			System.out.println("ENter correctusername");
			pageName="userfailforusername.html"; 	
		}
		
	return pageName;
		
	}
//------------------------------------------------------------------------------------------------//	
	public String checkAndGetPassword(User u)
	{
		String page=null;
		
		if(userrepo.existsById(u.getEmail()))
		{
			User user=userrepo.getById(u.getEmail());
			
			String str=user.getMobile().substring(6);
		
			if(u.getMobile().equals(str))
			{
				String actualpass=user.getPassword();
				page= "YOUR ACTUAL PASSWORD IS :"+actualpass;
			}
			else
			{
				page="ENTER THE LAST 4 DIGITS OF MOBILE NUMBER CORRECTLY !!!!";
			}
		}
		else
		{
			page="ENTER THE VALID EMAIL ID !!!!! ";
		}
		return page;
		
	}

//---------------------------------------------------------------------------------------------//
	public User getUserById(String email) 
	{
		Optional<User> optional=userrepo.findById(email);
		User u=null;
		if(optional.isPresent())
		{
			u=optional.get();
		}
		else
		{
			throw new RuntimeException("User not found");
		}
		return u;
	}

	
//-----------------------------------------------------------------------------------------------//
	
	public void deleteUser(String email) 
	{
				userrepo.deleteById(email);
	}

//=================================================================================================//
	
	public List<User> getByBloodGroup(String blood_group) 
	{
//		Optional<User> user=userrepo.findByblood_group(blood_group);
		List<User> user=userrepo.findByblood_group(blood_group);
		return user;
	}
}
