package com.BookMyShow.BookMyShow.controller;

import com.BookMyShow.BookMyShow.DTO.BookdetailsDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/Admin")
public class AdminController {

    @PostMapping
    public ResponseEntity<Map<String, String>> BookTickets(@RequestBody BookdetailsDTO BookdetailsDTO) throws Exception {
        Map<String, String> re = new HashMap<>();
        try{

            re.put("Booking Status", "Booked");
        } catch (Exception e) {
            re.put("Booking Status", e.getMessage()); ;
        }
        return ResponseEntity.status(HttpStatus.OK).body(re);
    }
}
