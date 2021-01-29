package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.logindemo.LoginDemo;

@Repository
public interface LoginRepo extends JpaRepository<LoginDemo, Long> {

	@Query("SELECT u FROM LoginDemo u WHERE u.username = ?1 and u.password=?2")
	LoginDemo getUsername(String username, String password);

	@Query("SELECT u FROM LoginDemo u WHERE u.username = :username and u.status= 1")
	LoginDemo getuserRecord(String username);
	
	@Modifying
	@Query("update LoginDemo u set u.status = 0 where u.id= :id")
	void updateStatus(Long id);
	
//	@Query("select u.id= :id from LoginDemo u where u.status=0")
//	LoginDemo getuserRecord(Long id);
	
	
	
}

