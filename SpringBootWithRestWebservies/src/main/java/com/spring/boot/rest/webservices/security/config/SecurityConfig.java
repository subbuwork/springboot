/**
 * Author:Subbu
*Apr 12, 2017
*SpringBootWithRestWebservies
 */
package com.spring.boot.rest.webservices.security.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    Logger logger = LoggerFactory.getLogger(this.getClass());
	protected void configure(HttpSecurity http)throws Exception {
		logger.info("#####In side configure()#####");
		http.csrf().disable().authorizeRequests().anyRequest().authenticated().and().httpBasic();
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth)throws Exception{
		logger.info("#####In side configureGlobal()#####");
		auth.inMemoryAuthentication().withUser("user").password("user123").roles("USER");
		
	}
}
