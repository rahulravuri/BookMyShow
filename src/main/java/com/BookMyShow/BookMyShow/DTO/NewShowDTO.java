package com.BookMyShow.BookMyShow.DTO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class NewShowDTO {

    private int movieId;
    private int theatreId;
    private List<TheatreShowDTO> newShows;
}
