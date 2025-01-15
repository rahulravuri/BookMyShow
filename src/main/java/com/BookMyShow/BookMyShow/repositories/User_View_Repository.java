package com.BookMyShow.BookMyShow.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.BookMyShow.BookMyShow.models.User_View;

public interface User_View_Repository extends JpaRepository<User_View, Integer>{
	
	Optional<User_View> findByEmailid(String Email);

}
