package com.wipro.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.wipro.Constants;
import com.wipro.handler.UserAuthenticationSuccessHandler;
import com.wipro.model.Assessment;
import com.wipro.model.Question;
import com.wipro.model.Test;
import com.wipro.model.User;
import com.wipro.service.TestService;
import com.wipro.service.UserService;

@RestController
public class ResourceController {
	
	@Autowired
	private UserService userService;
	
//	@Autowired
//	@Lazy
//	@Qualifier("LoggedUser")
//	private org.springframework.security.core.userdetails.User loggedUser;
	
	@Autowired
	private TestService testService;
	
	@Autowired
	private UserAuthenticationSuccessHandler userAuthenticationSuccessHandler;
	
	@Autowired
	private InMemoryUserDetailsManager inMemoryUserDetailsManager;
	
	@Autowired
	@Qualifier("SpringAssessment")
	private Assessment springAssessment;
	
	@Autowired
	@Qualifier("HibernateAssessment")
	private Assessment hibernateAssessment;
	
	@GetMapping("/hello")
	public String sayHello()
	{
		return "Hello World !!";
	}
	
	@RequestMapping("/welcome")
	public ModelAndView firstPage() {
		return new ModelAndView("welcome");
	}
	
	@RequestMapping("/welcomeAdmin")
	public ModelAndView welcomeAdmin() {
		return new ModelAndView("welcomeAdmin");
	}
	
	@RequestMapping("/welcomeUser")
	public ModelAndView welcomeUser() {
		return new ModelAndView("welcomeUser");
	}
	
	@RequestMapping("/invalidUser")
	public ModelAndView invalidUser() {
		return new ModelAndView("invalidUser");
	}
	
	@RequestMapping(value = "/addNewUser", method = RequestMethod.GET)
	public ModelAndView show() {
		return new ModelAndView("addUser", "user", new User());
	}
	
	
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public ModelAndView processRequest(@ModelAttribute("user") User user) {
		user.setUserType("USER");
		user.setUserTypeValue("candidate");
		userService.addUser(user);
		ModelAndView model = new ModelAndView("userAdded");
		model.addObject("user", user);
		
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
 
		inMemoryUserDetailsManager.createUser(
				new org.springframework.security.core.userdetails.User(
				user.getEmail(),
				"{noop}"+user.getPassword(),
				true, true, true, true,
				authorities
				));

		return model;
	}
	
	@RequestMapping("/getUser")
	public ModelAndView getUsers() {
		List<User> users = userService.getAllUser();
		ModelAndView model = new ModelAndView("getUser");
		model.addObject("users", users);
		return model;
	}
	
	@RequestMapping("/getTest")
	public ModelAndView getTestData() {
		List<Test> testData = testService.getAllTest();
		ModelAndView model = new ModelAndView("getTest");
		model.addObject("testData", testData);
		return model;
	}
	
	@GetMapping("/springAssessment")
	public ModelAndView springAssessment() {
		
		ModelAndView model = new ModelAndView("assessment");
		model.addObject("assessment", springAssessment);
	    return model;
	}
	
	@GetMapping("/hibernateAssessment")
	public ModelAndView hibernateAssessment() {
		
		ModelAndView model = new ModelAndView("assessment");
		model.addObject("assessment", hibernateAssessment);
	    return model;
	}
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView model1 = new ModelAndView("login");

		if(userService.getAllUser().size() == 0) {
			userService.addUser(new User("roger@gmail.com", "Roger", "Kutcher", "wipro@123", "ADMIN", "admin"));
			userService.addUser(new User("steve@gmail.com", "Steve", "Martin", "wipro@123", "ADMIN", "admin"));
		}
		return model1;
	}
	
	@PostMapping("/login")
	public ModelAndView postLogin()
	{
		ModelAndView model1 = new ModelAndView("login");
		return model1;
	}

	@PostMapping("/submit")
	public ModelAndView springSubmit(HttpServletRequest request) {
		String []questionIds = request.getParameterValues("questionId");
		String assessmentName = request.getParameter("assessment");
		int score = 0;
		for(String questionId : questionIds) {
			Question question = new Question();
			if(assessmentName.equalsIgnoreCase("Spring Assessment"))
				question = Constants.springQuestionAndAnswerOption[Long.valueOf(questionId).intValue()-1];
			else
				question = Constants.hibernateQuestionAndAnswerOption[Long.valueOf(questionId).intValue()-1];
			String answer = question.getAnswerOption()[question.getCorrectAnswer()-1];
			if(String.valueOf(request.getParameter("question_"+questionId)).equals(answer) )
			  score++;
		}

		Test test = new Test(
				          new Date(), 
				          (score * 10), 
				          50, 
				          score >= 3? "Passed": "Failed", 
				          assessmentName, 
				          userAuthenticationSuccessHandler.getLoggedUser().getUsername()
				          );
		
		testService.addTest(test);

		ModelAndView model = new ModelAndView("result");
		if(score >= 3) 
		{
			model.addObject("title", "Success Page");
			model.addObject("score", "Congratulations !!! You have passed !!!");
		}
		else
		{
			model.addObject("title", "Failure Page");
			model.addObject("score", "Sorry !!! Better 	Luck Next Time !!!");		
		}
	    return model;
	}
	
	
	@RequestMapping(value = "/username", method = RequestMethod.GET)
	public String currentUserName() {
		return userAuthenticationSuccessHandler.getLoggedUser().toString();
	}	
}
