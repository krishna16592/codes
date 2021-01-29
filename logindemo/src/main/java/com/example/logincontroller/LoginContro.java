package com.example.logincontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.logindemo.LoginDemo;
import com.example.loginservice.LoginService;

@RestController
public class LoginContro {
	
	@Autowired
	private LoginService loginService;
	
	@PostMapping("/loginsave")
	public ResponseEntity<?> save(@RequestBody LoginDemo loginDemo){
		return new ResponseEntity<>(loginService.save(loginDemo),HttpStatus.OK);
		
	}
	@GetMapping("/check")
	public ResponseEntity<?> check(@RequestParam(value="username") String username,@RequestParam(value="password") String password){
		
		return new ResponseEntity<>(loginService.gets(username,password),HttpStatus.OK);
	}
	
	@PutMapping("/get/{id}")
	public ResponseEntity<?> get(@PathVariable Long id){
		
		return new ResponseEntity<>(loginService.get(id),HttpStatus.OK);
	}
	
	@GetMapping("/userrecord")
	public ResponseEntity<?> userRecord(@RequestParam(value="username") String username,@RequestParam(value="password") String password){
		
		return new ResponseEntity<>(loginService.userRecord(username,password),HttpStatus.OK);
	}
	
	
	}
	
	
