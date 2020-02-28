package com.boot.services;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.boot.model.User;
import com.boot.repositories.UserDAO;

@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserDAO userDao;
   @Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
	System.out.println("this bean is called....!!!");
	   User user = userDao.getUserByUsername(userId);
	  
		
		if(user == null){
			System.out.println("user is null");
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		else {
			//System.out.println("user is read...!!!");
		}
		// System.out.println(user.getUsername());
		return new org.springframework.security.core.userdetails.User(user.getUsername(), new BCryptPasswordEncoder().encode(user.getPassword()), getAuthority(user));
	}

	private Collection<GrantedAuthority> getAuthority(User user) {
		
		Collection<GrantedAuthority> c=new ArrayList<GrantedAuthority>();
		if(user.getRole().equals("admin"))
		c.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		else
		c.add(new SimpleGrantedAuthority("ROLE_USER"));
		return c;
	}

	
}