package com.examly.springapp.User;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
@CrossOrigin(origins = "*")
public class UserController{
	@Autowired
    private UserService userService;

	
	@GetMapping("/users")
	public List<User> getAll()
	{
		return userService.getAllUsers();
	}

    @PostMapping("/signup")
    @ResponseBody
    public Map<String, String> addUser(@RequestBody User user)
    {
        return userService.addUser(user);
    }
    
    
}