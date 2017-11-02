package com.jirachai.domain.component;

import java.security.Principal;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import com.jirachai.domain.service.AppService;
import com.jirachai.domain.service.UserService;

@Controller
@Aspect
public class ControllerAspect {
	@Autowired
	UserService userService;
	
	@Autowired
	AppService appService;
	
//	private void setIsLogin(ModelAndView modelAndView, Principal principal) {
//		Authentication auth = (Authentication) principal;
//		if (auth != null && auth.isAuthenticated()) {
//			modelAndView.addObject("loggedIn", true);
//			UserDetails userDetails = (UserDetails) auth.getPrincipal();
//			modelAndView.addObject("userInfo", userDetails);
//			modelAndView.addObject("user", appService.findOne(principal));
//		} else {
//			modelAndView.addObject("loggedIn", false);
//		}
//	}
	
	@Before("execution(* com.jirachai.app.*.*Controller.*(..))")
	public void invokeBefore(JoinPoint joinPoint) {
		Principal principal = null;
		ModelAndView modelAndView = null;
		for (Object object : joinPoint.getArgs()) {
			if (object instanceof Principal) {
				principal = (Principal) object;
				System.out.println("\n\nPrincipal");
			} else if (object instanceof ModelAndView) {
				modelAndView = (ModelAndView) object;
				System.out.println("\n\nMV");
			}
		}
		if (principal != null && modelAndView != null) {
			setIsLogin(modelAndView, principal);
		}
	}
	
	private void setIsLogin(ModelAndView modelAndView, Principal principal) {
		Authentication auth = (Authentication) principal;
		if (auth != null && auth.isAuthenticated()) {
			modelAndView.addObject("isLogin", true);
			UserDetails userDetails = (UserDetails) auth.getPrincipal();
			modelAndView.addObject("userInfo", userDetails);
			modelAndView.addObject("loginUser", userService.findOne(principal));
		} else {
			modelAndView.addObject("isLogin", false);
		}

	}
}
