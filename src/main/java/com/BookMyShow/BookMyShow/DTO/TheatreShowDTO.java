package com.BookMyShow.BookMyShow.DTO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class TheatreShowDTO {
     private int ScreenId;
     private LocalDateTime showTime;
    private LocalDateTime showendTime;
}
