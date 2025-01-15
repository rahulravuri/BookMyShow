package com.BookMyShow.BookMyShow.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BookMyShow.BookMyShow.DTO.regionsDTO;
import com.BookMyShow.BookMyShow.models.Region;
import com.BookMyShow.BookMyShow.repositories.RegionRepository;

import lombok.*;
import lombok.Setter;

@Getter
@Service
@Setter
public class RegionService {
	private final RegionRepository re;
	
	@Autowired
	 public RegionService(RegionRepository re) {
	        this.re = re;
	    }
	 
	 public regionsDTO getRegions(){
		 List<Region> temp=new ArrayList<>();
		 temp= re.findAll();
		 regionsDTO out=new regionsDTO();
		 List<String> RegionName =new ArrayList<>();
		 for(Region i:temp) {
			 RegionName.add(i.getRegionname());
		 }
		 out.setRegionname(RegionName);
		 return out;
	 }
	
	

}
