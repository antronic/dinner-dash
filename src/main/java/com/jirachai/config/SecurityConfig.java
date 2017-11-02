package com.jirachai.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.jirachai.domain.service.LoginService;

@Configuration
@ComponentScan("com.concretepage")
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	LoginService loginService;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		Md5PasswordEncoder encoder = new Md5PasswordEncoder();
		auth.userDetailsService(loginService).passwordEncoder(encoder);
	}

	@Override    
	protected void configure(HttpSecurity http) throws Exception {        
		http.authorizeRequests()            
		.and().authorizeRequests()
		.antMatchers("/static/**","/vendor/**", "/img/**", "/**/favicon.ico","/fonts/**","/css/**")
		.permitAll()       
		.and()
		.authorizeRequests()
		.antMatchers("/", "/user/login","/user/register", "/user/create", "/help", "/contact", "/about", "/loginUser")
		.permitAll()            
		.anyRequest()
		.authenticated()            
		.and()            
		.csrf()            
		.disable()            
		.formLogin()            
		.loginPage("/user/login")            
		.defaultSuccessUrl("/user/success", true)    
		.failureUrl("/user/fail")
		.usernameParameter("email")
		.passwordParameter("password")
		.permitAll()
		.and()
		.logout()
		.logoutUrl("/user/logout")
		.logoutSuccessUrl("/")
		.logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"));
	}
}
