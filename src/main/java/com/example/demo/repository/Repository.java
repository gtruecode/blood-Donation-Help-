package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.models.Admin;


public interface Repository extends JpaRepository<Admin, String>{

}
