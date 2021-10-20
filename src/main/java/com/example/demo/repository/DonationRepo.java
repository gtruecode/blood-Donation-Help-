package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Donation;

public interface DonationRepo extends JpaRepository<Donation, Long>
{
	

}
