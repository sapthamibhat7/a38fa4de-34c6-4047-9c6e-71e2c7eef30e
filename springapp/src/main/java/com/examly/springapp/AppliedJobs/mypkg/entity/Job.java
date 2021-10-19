package com.example.mypkg.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Job {
	@Id
    private String jobId;
	private String jobname;
	private String employeeId;
	private String appliedDate;
	

	
	
	
	
}
