package com.examly.springapp.User;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface LoginRepository extends CrudRepository<Login,String>{
	public Optional<Login> findByUserId(String id);
	
}
