package com.BookMyShow.BookMyShow.repositories;

import com.BookMyShow.BookMyShow.models.Theatre;
import com.BookMyShow.BookMyShow.models.TheatreShowHandler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

@Repository
public interface TheatreShowHRepository extends JpaRepository<TheatreShowHandler, Integer> {

    @Async
    @Procedure(name = "Create_Shows")
    void Create_Shows(int BathId);
}
