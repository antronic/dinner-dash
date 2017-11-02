package com.jirachai.app.user;

import java.security.NoSuchAlgorithmException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jirachai.app.user.UserCreateForm;
import com.jirachai.domain.service.UserService;


@Controller
public class RegisterController {
	@Autowired
	UserService userService;
	
	@RequestMapping("/user/register")
	public ModelAndView renderRegister(ModelAndView modelAndView) {
		modelAndView.setViewName("/user/register");
		modelAndView.addObject("userCreateForm", new UserCreateForm());
		return modelAndView;
	}
	
	@RequestMapping("/user/create")
	public Object add(@ModelAttribute("userCreateForm") @Valid UserCreateForm userAddForm, BindingResult bindingResult,
			RedirectAttributes attributes, ModelAndView modelAndView) throws NoSuchAlgorithmException {
		if (bindingResult.hasErrors()) {
			return "user/register";
		}
		userService.createUser(userAddForm);
		attributes.addFlashAttribute("messageDialog", "User was created.");
		return "redirect:/user/login";
	}
}
