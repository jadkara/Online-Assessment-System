package com.wipro.handler;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import org.springframework.security.core.userdetails.User;

@Component
public class UserAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	private Authentication myAuthentication;
	
	private User loggedUser;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest arg0, HttpServletResponse arg1,
			Authentication authentication) throws IOException, ServletException {

		boolean hasUserRole = false;
		boolean hasAdminRole = false;
		this.myAuthentication = authentication;
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		for (GrantedAuthority grantedAuthority : authorities) {
			if (grantedAuthority.getAuthority().equals("ROLE_USER")) {
				hasUserRole = true;
				break;
			} else if (grantedAuthority.getAuthority().equals("ROLE_ADMIN")) {
				hasAdminRole = true;
				break;
			}
		}
		
		loggedUser = (User) myAuthentication.getPrincipal();
		
//		UserDetails userDetails = (UserDetails) 
//			System.out.println("\n\n\n authentication.getPrincipal()="+authentication.getPrincipal());

		if (hasUserRole) {
			redirectStrategy.sendRedirect(arg0, arg1, "/welcomeUser");
		} else if (hasAdminRole) {
			redirectStrategy.sendRedirect(arg0, arg1, "/welcomeAdmin");
		} else {
			throw new IllegalStateException();
		}
	}

	public User getLoggedUser() {
		return loggedUser;
	}

	public void setLoggedUser(User loggedUser) {
		this.loggedUser = loggedUser;
	}
	
	
	
	
//	@Bean(value = "LoggedUser")
//	@Lazy(true)
//	public User getUserDetails()
//	{
//	   User user = (User) myAuthentication.getPrincipal();
//	   return user;
//	}

}