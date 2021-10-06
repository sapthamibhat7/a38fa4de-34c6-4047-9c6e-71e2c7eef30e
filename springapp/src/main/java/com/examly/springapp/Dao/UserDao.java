package com.examly.springapp.Dao;
import org.springframework.data.repository.CrudRepository;
import com.examly.springapp.model.User;
import java.util.List;

public interface UserDao extends CrudRepository<User, Integer> {
    List<User> findByEmail(String email);
}
