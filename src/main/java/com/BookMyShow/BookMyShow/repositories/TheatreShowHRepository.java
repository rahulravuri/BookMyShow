package com.BookMyShow.BookMyShow.repositories;

import com.BookMyShow.BookMyShow.models.Theatre;
import com.BookMyShow.BookMyShow.models.TheatreShowHandler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

@Repository
public interface TheatreShowHRepository extends JpaRepository<TheatreShowHandler, Integer> {

    @Procedure(name = "Create_Show")
    void Create_Show(int BathId);
}
