package com.BookMyShow.BookMyShow.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Region {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int RegionID;	
	@Column(name="region_name")
	private String regionname;
	@OneToMany(mappedBy = "region" , fetch = FetchType.LAZY)
	private List<Theatre> theatres; 
	

}
