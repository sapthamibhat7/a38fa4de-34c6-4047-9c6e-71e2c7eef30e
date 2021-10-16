package com.examly.springapp.User;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.examly.springapp.Constants.ResponseCode;
import com.examly.springapp.Response.serverResp;

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
	
	public ResponseEntity<serverResp> isUser(LoginData loginData)
	{
		serverResp resp = new serverResp();
		String userId=userService.getUserId(loginData.getEmail());
		if(userId==null){
			resp.setStatus(ResponseCode.FAILURE_CODE);
			resp.setMessage(ResponseCode.FAILURE_MESSAGE);
		}
		Optional<Login> login=loginRepository.findByUserId(userId);
		if(login.isPresent()==false){
			resp.setStatus(ResponseCode.FAILURE_CODE);
			resp.setMessage(ResponseCode.FAILURE_MESSAGE);
		}
		Login loginUser=login.get();
		if(loginUser.getPassword().equals(loginData.getPassword())){
			resp.setStatus(ResponseCode.SUCCESS_CODE);
			resp.setMessage(ResponseCode.SUCCESS_MESSAGE);
		}
		return new ResponseEntity<serverResp>(resp, HttpStatus.OK);
	}
}
