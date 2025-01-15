package com.BookMyShow.BookMyShow.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "Theatres")
public class Theatre {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int theatreID;
	@OneToMany(mappedBy = "Theatre")
	private List<TheatreScreen> Screens;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="RegionID")
	private Region region;
	
	private String theatreName;
	

}
