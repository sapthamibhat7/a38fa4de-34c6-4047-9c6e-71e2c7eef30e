 
package com.examly.springapp.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers()
    {
        List<User> users=new ArrayList<>();
        userRepository.findAll()
        .forEach(user -> users.add(user));
        return users;
    }

    public User getUser(String email)
    {
        Optional<User> user=userRepository.findById(email);
        if(user.isPresent()) return user.get();
        return null;
    }

    public String getUser(Login login)
    {
    	User user=getUser(login.getEmail()); 
    	if(user==null) return "User doesn't exist. Please signup first";
    	if(user.getPassword().equals(login.getPassword())) return "Login Successful";
    	return "Password wrong";
    }
    
    public String addUser(User user) {
    	if(getUser(user.getEmail())!=null) return "User already exists";
		userRepository.save(user);
		return "User successfully registered";

	}

	public void updateTopic(int id, User user) {
		userRepository.save(user);

	}

	public void deleteUser(String email) {
		userRepository.deleteById(email);
	}
}
