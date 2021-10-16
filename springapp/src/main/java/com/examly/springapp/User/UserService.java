 
package com.examly.springapp.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Map;
import java.util.HashMap;

import org.springframework.web.bind.annotation.ResponseBody;
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

    @ResponseBody
    public Map<String, String> addUser(User user) {
    	if(getUser(user.getEmail())!=null){
            HashMap<String,String> map = new HashMap<>();
            map.put("Error","User already exists");
            return map;
        }
		userRepository.save(user);
		Login login=new Login(user.getId(),user.getPassword());
		loginService.addLogin(login);
        HashMap<String,String> map = new HashMap<>();
        map.put("Success","User successfully registered");
        return map;

	}

	public void updateUser(User user) {
		userRepository.save(user);

	}

	public void deleteUser(String email) {
		userRepository.deleteById(email);
	}
}
