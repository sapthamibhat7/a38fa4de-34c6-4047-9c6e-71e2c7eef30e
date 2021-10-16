package com.examly.springapp.User;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Login {
	
	@Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
	private String Id;
	
	private String password;
	
	@OneToOne(cascade=CascadeType.REMOVE, optional=true)
	private User user;
	
	public Login()
	{
		
	}
	
	public Login(String id,String password) {
		
		this.password=password;
		this.user=new User("","","","","");
		this.user.setId(id);
		this.Id = id;
	}
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
