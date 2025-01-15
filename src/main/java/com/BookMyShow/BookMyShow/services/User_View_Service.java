package com.BookMyShow.BookMyShow.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BookMyShow.BookMyShow.models.User_View;
import com.BookMyShow.BookMyShow.repositories.User_View_Repository;
import com.BookMyShow.BookMyShow.Exceptions.InvalidJwtException;
import com.BookMyShow.BookMyShow.Security.UserVerification;

@Service
public class User_View_Service {
	
	@Autowired
	User_View_Repository User_View_Repository;
	@Autowired
	UserVerification UserVerification;
	
	
	public User_View getUserDetails(String Email_id) {
		User_View user=User_View_Repository.findByEmailid(Email_id).get() ;
		return user;
		
	}
	
	public boolean userverification(String Token) throws InvalidJwtException {
		
		return UserVerification.userverification(Token,"user");

		
	}

}
