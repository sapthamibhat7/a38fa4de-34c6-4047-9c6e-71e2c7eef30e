 
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
    @Autowired
    private LoginService loginService;

    public List<User> getAllUsers()
    {
        List<User> users=new ArrayList<>();
        userRepository.findAll()
        .forEach(user -> users.add(user));
        return users;
    }

    public User getUser(String email)
    {
        Optional<User> user=userRepository.findByEmail(email);
        if(user.isPresent()) return user.get();
        return null;
    }

    public String getUserId(String email)
    {
    	User user=getUser(email); 
    	if(user==null) return null;
    	return user.getId();
    }
    
    public String addUser(User user) {
    	if(getUser(user.getEmail())!=null) return "User already exists";
		userRepository.save(user);
		Login login=new Login(user.getId(),user.getPassword());
		loginService.addLogin(login);
		return "User successfully registered";

	}

	public void updateUser(User user) {
		userRepository.save(user);

	}

	public void deleteUser(String email) {
		userRepository.deleteById(email);
	}
}
