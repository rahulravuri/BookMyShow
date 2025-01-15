package com.BookMyShow.BookMyShow.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.BookMyShow.BookMyShow.DTO.theatreDTO;
import com.BookMyShow.BookMyShow.models.Region;
import com.BookMyShow.BookMyShow.models.Theatre;

@Repository
public interface TheatreRepository extends JpaRepository<Theatre, Integer>{
	@Query("select r.regionname ,t.theatreName theatreName,t.theatreID from Region r join r.theatres t where r.RegionID= :RegionID")
	List<Object[]> getTheatrebyregionList(@Param("RegionID") int RegionID);

}
