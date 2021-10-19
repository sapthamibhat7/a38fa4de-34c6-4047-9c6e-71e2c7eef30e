package com.example.mypkg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.mypkg.dto.ApplyRequest;
import com.example.mypkg.dto.ApplyResponse;
import com.example.mypkg.entity.Job;
import com.example.mypkg.repository.EmployeeRepository;
import com.example.mypkg.repository.JobRepository;

@RestController
public class ApplyController {
	@Autowired
	private JobRepository jr;
	@Autowired
	private EmployeeRepository er;
	
	@PostMapping("/jobapply")
	public Job jobapply(@RequestBody ApplyRequest request)
	{
		
		return jr.save(request.getJob());
		
	}
	
	@GetMapping("/FindAllAppliedJobs")
	public List<Job> FindAllAppliedJobs()
	{
		return jr.findAll();
		
	}
	
	@GetMapping("/getInfo")
	public List<ApplyResponse> getJoinInformation()
	{
		return jr.getJoinInformation();
		
	}
	
	
	
	
	
	



}
