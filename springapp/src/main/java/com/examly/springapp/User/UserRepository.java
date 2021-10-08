 
package com.examly.springapp.User;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer>{
    Optional<User> findByEmail(String email);
}
