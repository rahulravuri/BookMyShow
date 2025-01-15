package com.BookMyShow.BookMyShow.DTO;

import java.time.LocalDateTime;

import com.BookMyShow.BookMyShow.models.screenType;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class showDTO {
	
	private int showid;
	private String TheatreName;
	private String MovieName;
	private LocalDateTime showTime;
	private screenType screentype;
	private String time;
	

}
