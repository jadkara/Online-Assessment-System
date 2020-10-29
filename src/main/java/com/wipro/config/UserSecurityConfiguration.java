package com.wipro.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import com.wipro.Constants;
import com.wipro.handler.CustomAuthenticationFailureHandler;
import com.wipro.handler.UserAuthenticationSuccessHandler;
import com.wipro.model.Assessment;
import com.wipro.model.Question;

@Configuration
@EnableWebSecurity
public class UserSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserAuthenticationSuccessHandler successHandler;
	
	@Autowired
	private CustomAuthenticationFailureHandler customAuthenticationFailureHandler;

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(inMemoryUserDetailsManager());
	}

	@Bean
	public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
		final Properties users = new Properties();
		users.put("roger@gmail.com", "{noop}wipro@123,ROLE_ADMIN,enabled");
		users.put("steve@gmail.com", "{noop}wipro@123,ROLE_ADMIN,enabled");
		return new InMemoryUserDetailsManager(users);
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/addNewUser");
		web.ignoring().antMatchers("/addUser");
		web.ignoring().antMatchers("/userAdded");
//		web.ignoring().antMatchers("/springAssessment");
//		web.ignoring().antMatchers("/hibernateAssessment");
//		web.ignoring().antMatchers("/username");
		web.ignoring().antMatchers("/invalidUser");
//		web.ignoring().antMatchers("/assessment");
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()// .antMatchers("/").permitAll()
				.antMatchers("/welcomeAdmin").hasAnyRole( "ADMIN")
				.antMatchers("/welcomeUser").hasAnyRole( "USER")
				
				.antMatchers("/getUser").hasAnyRole( "ADMIN")
				.antMatchers("/getTest").hasAnyRole( "ADMIN")
				
				.antMatchers("/springAssessment").hasAnyRole( "USER")
				.antMatchers("/hibernateAssessment").hasAnyRole( "USER")
				.anyRequest().authenticated().and()
				.formLogin().successHandler(successHandler)
				
				.failureHandler(customAuthenticationFailureHandler)
				.loginPage("/login")
				.failureUrl("/invalidUser")

				.permitAll().and().logout().permitAll();

		http.csrf().disable();
	}
	
	@Bean(value = "SpringAssessment")
	public Assessment getSpringAssessment() {
		List<Question> questions = new ArrayList<Question>(Arrays.asList(Constants.springQuestionAndAnswerOption));
		Assessment assessment = new Assessment("Spring Assessment", questions);
		return assessment;
	}
	
	
	@Bean(value = "HibernateAssessment")
	public Assessment getHibernateAssessment() {
		List<Question> questions = new ArrayList<Question>(Arrays.asList(Constants.hibernateQuestionAndAnswerOption));
		Assessment assessment = new Assessment("Hibernate Assessment", questions);
		return assessment;
	}
}