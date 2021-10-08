 
package com.examly.springapp.User;

import java.lang.StackWalker.Option;
import java.util.ArrayList;
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
        Optional<User> user=userRepository.findByEmail(email);
        if(user.isPresent()) return user.get();
        return null;
    }

    public void addUser(User user) {
		userRepository.save(user);

	}

	public void updateTopic(int id, User user) {
		userRepository.save(user);

	}

	public void deleteUser(int id) {
		topicRepository.deleteById(id);
	}
}
