package com.jirachai.domain.service;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

//import com.arms.domain.entity.RelationShip;
import com.jirachai.domain.entity.User;
//import com.arms.domain.repository.MicropostRepository;
//import com.arms.domain.repository.RelationShipRepository;
//import com.arms.domain.repository.UserRepository;
import com.jirachai.domain.repository.UserRepository;

@Service
public class AppService {
	@Autowired
	UserRepository userRepository;
//
//	@Autowired
//	MicropostRepository micropostRepository;
//	
//	@Autowired
//	RelationShipRepository relationShipRepository;
	
//	public List<RelationShip> getFollowerListByUserId(int userId) {
//		return relationShipRepository.findAllByUserId(userId);
//	}
//
//	public List<RelationShip> getFollowingListByUserId(int userId) {
//		return relationShipRepository.findAllByFollowerId(userId);
//	}

	public Integer getUserId(Principal principal) {
		if (principal == null)
			return null;
		else {
			Authentication auth = (Authentication) principal;
			UserDetails userDetails = (UserDetails) auth.getPrincipal();
			User user = userRepository.findOneByEmail(userDetails.getUsername());
			if (user == null)
				return null;
			else
				return user.getId();
		}
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
}

