package com.jirachai.app.user;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jirachai.domain.service.LoginService;

@Controller
public class LoginController {
	@Autowired
	LoginService loginService;
	
	@RequestMapping("/user/login")
	public ModelAndView loginPage(ModelAndView modelAndView) {
		modelAndView.setViewName("user/login");
		return modelAndView;
	}
	
	@RequestMapping("/user/success")
	public Object loginSuccess(ModelAndView modelAndView, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("/user/login");
			return modelAndView;
		}
		redirectAttributes.addFlashAttribute("message", "Login Successful");
		modelAndView.addObject("loginSuccess", true);
		return "redirect:/app/dashboard";
	}
	
	@RequestMapping(value = "/user/fail", method = RequestMethod.GET)
	public ModelAndView failLogin(ModelAndView modelAndView) {
		modelAndView.addObject("errorMsg", "Login failed, Invalid name and/or passwod");
		modelAndView.addObject("loginFail", true);
		modelAndView.setViewName("user/login");
		return modelAndView;
	}
	
	@RequestMapping("/loginUser")
	@ResponseBody
	public String currentUser(Principal principal){
	if(principal != null){
	return principal.getName();
	} else {
	return "pricipal is null!!";
	} }
}
