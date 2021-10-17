package com.example.mypkg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.mypkg.dto.ApplyResponse;
import com.example.mypkg.entity.Job;

public interface JobRepository extends JpaRepository<Job,String> {
	
  @Query("SELECT new com.example.mypkg.dto.ApplyResponse(b.*, a.name )FROM Job b JOIN b.Employee a ")
   public List<ApplyResponse> getJoinInformation();
}
