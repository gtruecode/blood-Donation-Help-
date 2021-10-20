package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Donation;
import com.example.demo.repository.DonationRepo;

@Service
public class DonationService 
{
  @Autowired
  DonationRepo donrepo;
  
  public void saveDonationList(Donation d)
  {  
	donrepo.save(d);  
  }
  
  public List<Donation> getDonationList()
  {
	  return donrepo.findAll();
  }
  
  
}
