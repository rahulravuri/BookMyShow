package com.BookMyShow.BookMyShow.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BookMyShow.BookMyShow.models.MovieShow;
import com.BookMyShow.BookMyShow.models.User;

@Repository
public interface userRepository extends JpaRepository<User, Integer> {

}
