package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.models.User;

@Repository
public interface UserRepo extends JpaRepository<User, String>
{
	@Query("from User where blood_group=?1 ")
	public List<User> findByblood_group(String blood_group);

}

