package com.jirachai.app.user;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

@Data
public class UserCreateForm {
	@NotEmpty
	private String name;
	@NotEmpty
	private String email;
	@NotEmpty
	private String password;
}
