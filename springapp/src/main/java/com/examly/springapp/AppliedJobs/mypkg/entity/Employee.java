package com.example.mypkg.entity;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Employee {
	@Id
	@GeneratedValue
	 private String employeeId;
	 private String name;
	 @OneToMany(targetEntity =Job.class,cascade=CascadeType.ALL)
	 @JoinColumn(name="jobList",referencedColumnName="employeeId")
	 private List<Job> jobs;
	 



}
