package com.jirachai.domain.service;

import java.security.Principal;

import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.jirachai.domain.component.PasswordEncoder;
import com.jirachai.app.user.UserCreateForm;
import com.jirachai.domain.entity.User;

@Service
public class UserService extends AppService{
	@Autowired
	PasswordEncoder passwordEncoder;

	public void createUser(UserCreateForm userAddForm) throws NoSuchAlgorithmException {
		User user = new User();
		user.setName(userAddForm.getName());
		user.setEmail(userAddForm.getEmail());
		user.setPassword(passwordEncoder.hashMD5(userAddForm.getPassword()));
		user.setLevel("USER");
		user.setStatus(1);
		userRepository.save(user);
	}
	
	public User findOne(Principal principal) {
		if (principal == null) {
			return null;
		} else {
			Authentication auth = (Authentication) principal;
			UserDetails userDetails = (UserDetails) auth.getPrincipal();
			return userRepository.findOneByEmail(userDetails.getUsername());
		}
	}
	
	public User findOne(int userId) {
		return userRepository.findOne(userId);
	}
}
