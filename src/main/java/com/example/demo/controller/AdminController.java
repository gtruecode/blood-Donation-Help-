package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.models.Admin;
import com.example.demo.models.Donation;
import com.example.demo.repository.DonationRepo;
import com.example.demo.repository.UserRepo;
import com.example.demo.services.AdminService;
import com.example.demo.services.DonationService;

@Controller
public class AdminController 
{
	@Autowired
	AdminService adminservice;
	
	@Autowired
	DonationService Donservice;
	
	@Autowired
	DonationRepo Donrepo;
	
	@Autowired
	UserRepo userrepo;
	
	@RequestMapping("/")
	public String adminLoginPage()
	{
		return "homepage.html";
	}
	
	@RequestMapping("/aboutus")
	public String aboutusPage()
	{
		return "aboutus.html";
	}

	
	@RequestMapping("/adminlogin")
	public String LoginPage(Model m)
	{
		Admin admin=new Admin();
		m.addAttribute("admin", admin);
		return "adminLogin.html";
	}
	
	@RequestMapping("/checkadminlogin")
    public String action(@ModelAttribute("admin") Admin a)
    {

		String page=adminservice.checkLogin(a);
		return page;
    }
	
	@RequestMapping("/donateus")
	public String getDonationForm(Model m)
	{
		Donation donation =new Donation();
		m.addAttribute("donationbind", donation);
		return "donationForm.html";	
	}
	
	
	
	@RequestMapping("/donationlist")
	public String donationlist(Model p) 
	{
		p.addAttribute("donation", Donservice.getDonationList());
		return "donationlist.html";
	}
	
	
	
	@RequestMapping("/savedonations")
	public String saveDonations(@ModelAttribute("donationbind") Donation d)
	{
		Donservice.saveDonationList(d);
		return "display.html";
		
	}
	
	@RequestMapping("/displayusers")
	public String getUsers(Model m) 
	{
		m.addAttribute("users", userrepo.findAll());
		return "user.html";
	}
}
