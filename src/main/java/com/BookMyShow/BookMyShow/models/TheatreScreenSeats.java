package com.BookMyShow.BookMyShow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class TheatreScreenSeats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ScreenSeatId;

    @ManyToOne
    @JoinColumn(name="ScreenId", nullable = false)
    private TheatreScreen screen;

    @Enumerated(EnumType.STRING)
    private SeatType seattype;

    private int seatrow;

    private int seatcol;
}
