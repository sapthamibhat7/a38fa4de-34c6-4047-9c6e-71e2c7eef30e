package com.examly.springapp.User;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

	@Autowired
	private LoginRepository loginRepository;
	@Autowired
	private UserService userService;
	
	public void addLogin(Login login)
	{
		loginRepository.save(login);
	}
	
	public boolean isUser(LoginData loginData)
	{
		String userId=userService.getUserId(loginData.getEmail());
		if(userId==null) return false;
		Optional<Login> login=loginRepository.findByUserId(userId);
		if(login.isPresent()==false) return false;
		Login loginUser=login.get();
		if(loginUser.getPassword().equals(loginData.getPassword())) return true;
		return false;
	}
}
