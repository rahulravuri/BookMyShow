package com.BookMyShow.BookMyShow.DTO;

import java.util.ArrayList;
import java.util.List;

import com.BookMyShow.BookMyShow.models.Theatre;

import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class regionsDTO {
	
	public regionsDTO() {
		this.regionname=new ArrayList<>();
	}
	
	private List<String> regionname;


}
