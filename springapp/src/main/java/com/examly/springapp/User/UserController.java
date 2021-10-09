package com.examly.springapp.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
    public String addUser(@RequestBody User user)
    {
        return userService.addUser(user);
    }
    
    @PostMapping("/login")
    public String getUser(@RequestBody Login login)
    {
    	return userService.getUser(login);
    }
}