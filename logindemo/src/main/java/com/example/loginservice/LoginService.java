package com.example.loginservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.logindemo.LoginDemo;
import com.example.repository.LoginRepo;

@Service
@Transactional
public class LoginService {
	
	@Autowired
	private LoginRepo loginRepo;

	public LoginDemo save(LoginDemo loginDemo) {
		loginDemo.setStatus(true);
		LoginDemo objLogin=loginRepo.save(loginDemo);
		return objLogin;
		
	}

	public String gets(String username,String password) {
		String msg=null;
		LoginDemo objLoginDemo = loginRepo.getUsername(username, password);
		if(objLoginDemo == null) {
			msg = "Username and password incorrect";
		} else { 
			msg = "success";
		}
		return msg;
			
	}

	public String get(Long id) {
		
		loginRepo.updateStatus(id);
		return "deactived";
		
	}

	public String userRecord(String username,String password) {
		String string1=null;
		LoginDemo objLoginDemo= loginRepo.getuserRecord(username);
		if(objLoginDemo == null) {
			string1 = "user is deactivated by admin";
		} else if(objLoginDemo.getPassword().equals(password))
		{
			string1="password matched";
		}
		else {
		string1 = "password is incorrect";
		}
		return string1;
	}
	

}
