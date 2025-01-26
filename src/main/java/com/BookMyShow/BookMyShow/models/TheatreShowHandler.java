package com.BookMyShow.BookMyShow.models;

import com.BookMyShow.BookMyShow.Utill.JsonShowConverter;
import com.fasterxml.jackson.databind.JsonNode;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class TheatreShowHandler {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private int Movieid;
    private int TheatreId;
    @Enumerated(EnumType.STRING)
    private TheatreShowStatus TheatreShowStatus;
    @Convert(converter = JsonShowConverter.class)
    @Column(name = "shows_data", columnDefinition = "json")
    private JsonNode showsData;
    private LocalDateTime CreationTime;
    private String Information;


}
