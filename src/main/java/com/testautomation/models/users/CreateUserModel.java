package com.testautomation.models.users;

import lombok.Data;

@Data
public class CreateUserModel {
	
	private String name;
	private String job;
	private String email;
	private String password;
	
}
