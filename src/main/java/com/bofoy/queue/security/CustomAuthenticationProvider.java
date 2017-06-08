package com.bofoy.queue.security;

import java.util.List;

import javax.transaction.Transactional;

import java.util.ArrayList;

import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.bofoy.queue.domain.Role;
import com.bofoy.queue.domain.User;
import com.bofoy.queue.service.UserService;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	private static final Logger logger = LoggerFactory.getLogger(CustomAuthenticationProvider.class);
	
	@Autowired
	private UserService userService;
	
	@Transactional
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String name = authentication.getName();
		String password = String.valueOf(authentication.getCredentials());
		
		logger.info("user:{}, password:{}", name, password);
		
		User user = userService.findUser(name);
		logger.info("Salt is:{}", user.getPasswordSalt());
		String hashedPassword = BCrypt.hashpw(password, user.getPasswordSalt());
		
		if (!user.getPassword().equals(hashedPassword)) {
			throw new BadCredentialsException("Bad Credentials");
		}

		logger.info("Authenticated! user:{}, password:{}", name, password);
		
		List<GrantedAuthority> authorities = new ArrayList<>();
		for (Role role : user.getRoles()) {
			logger.info("User has role:{}", role.getRoleName());
			authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
		}
		
		return new UsernamePasswordAuthenticationToken(user, password, authorities);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
