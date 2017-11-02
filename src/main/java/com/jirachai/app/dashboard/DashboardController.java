package com.jirachai.app.dashboard;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//import com.jirachai.domain.component.ControllerAspect;

@Controller
public class DashboardController {
	
//	@Autowired
//	ControllerAspect controllerAspect; 
	
	@RequestMapping("/app/dashboard")
	public ModelAndView dashboard(ModelAndView modelAndView, Principal principal) {
//		controllerAspect.setIsLogin(modelAndView, principal);
		System.out.println("\n\n\n\n\n\n\n111111111111111111111111111111111");
		modelAndView.addObject("test", "xxx");
		modelAndView.setViewName("/app/dashboard");
		return modelAndView;
	}
}
