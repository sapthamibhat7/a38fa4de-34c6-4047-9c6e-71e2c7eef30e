package com.examly.springapp.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.examly.springapp.Response.serverResp;
import org.springframework.http.ResponseEntity;

@RestController
@CrossOrigin(origins = "*")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@PostMapping("/login")
	public ResponseEntity<serverResp> checkUser(@RequestBody LoginData loginData)
	{
		return loginService.isUser(loginData);
	}
}
