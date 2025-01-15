package com.BookMyShow.BookMyShow.Security;
import com.BookMyShow.BookMyShow.Utill.KeyUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import java.security.PublicKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.BookMyShow.BookMyShow.Exceptions.InvalidJwtException;
import com.BookMyShow.BookMyShow.models.User_View;
import com.BookMyShow.BookMyShow.services.User_View_Service;

@Component
public class UserVerification {

	@Autowired
	PublicKey PublicKey;

	public boolean userverification(String Token,String Access) throws InvalidJwtException {

		Claims data=KeyUtil.parseJwt(Token,PublicKey);
		return Access==data.get("role",String.class);
	}

}
