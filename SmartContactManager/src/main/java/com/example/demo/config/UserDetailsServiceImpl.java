package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.demo.dao.UserRepo;
import com.example.demo.entity.User;

public class UserDetailsServiceImpl implements UserDetailsService {
     
	@Autowired
	private UserRepo userrepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = this.userrepo.getUserByUserName(username);
		if(user==null) {
			
			throw new UsernameNotFoundException("Could not found Exception");
			
		}
		
		CustomUserDetails customUserDetails = new CustomUserDetails(user);
		System.out.println(customUserDetails);
		return customUserDetails;
	}

}
