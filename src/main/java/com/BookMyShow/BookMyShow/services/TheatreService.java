package com.BookMyShow.BookMyShow.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BookMyShow.BookMyShow.DTO.theatreDTO;
import com.BookMyShow.BookMyShow.repositories.RegionRepository;
import com.BookMyShow.BookMyShow.repositories.TheatreRepository;

@Service
public class TheatreService {
	private TheatreRepository re;
	
	@Autowired
	public TheatreService(TheatreRepository re) {
        this.re = re;
    }
	

	public ArrayList<Integer> getalltheatres(){
		return new ArrayList<Integer>();
	}
	
	public List<Object[]> getalltheatresbyregion(int rid){
		
		return re.getTheatrebyregionList(rid);
	}
}
