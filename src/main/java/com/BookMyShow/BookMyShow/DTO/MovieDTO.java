package com.BookMyShow.BookMyShow.DTO;

import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MovieDTO {
	
	private String name;
	private String actor;
	private int movieid;
	

}
