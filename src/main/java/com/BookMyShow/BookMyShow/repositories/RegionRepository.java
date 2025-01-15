package com.BookMyShow.BookMyShow.repositories;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.BookMyShow.BookMyShow.models.Region;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface RegionRepository extends JpaRepository<Region, Integer> {
	
	//@Query("select r.RegionName from Region r")


}
