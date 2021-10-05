package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.examly.springapp.model.User;
import com.examly.springapp.Dao.UserDao;

@SpringBootApplication
@RestController
@CrossOrigin(origins = "*")

public class UserController {
	
	@Autowired
	private UserDao dao;

	@PostMapping("/signup")
	public String saveUser(@RequestBody User user) {
		dao.save(user);
		return "Hi " + user.getUserName() + " successfully registered";
	}

	@GetMapping("/getusers")
	public List<User> getUsers() {
		return (List<User>) dao.findAll();
	}

	@GetMapping("/finduser/{email}")
    public List<User> findUser(@PathVariable String email) {
        return dao.findByEmail(email);
    }

    @DeleteMapping("/cancel/{id}")
    public List<User> cancelRegistration(@PathVariable int id) {
        dao.deleteById(id);
        return (List<User>) dao.findAll();
    }


}