package com.BookMyShow.BookMyShow.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.BookMyShow.BookMyShow.models.MovieShow;
import com.BookMyShow.BookMyShow.models.User;

import java.util.Optional;

@Repository
public interface userRepository extends JpaRepository<User, Integer> {

}
